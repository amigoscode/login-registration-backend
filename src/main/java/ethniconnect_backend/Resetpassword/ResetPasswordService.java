package ethniconnect_backend.Resetpassword;

import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import ethniconnect_backend.ChefSignup.token.ConfirmationToken;
import ethniconnect_backend.ChefSignup.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ResetPasswordService {

    @Autowired
    UserCredentialsService userCredentialsService;
    @Autowired
    UserCredentialsRepository userCredentialsRepository;
    @Autowired
      EmailSender emailSender;
      @Autowired
      EmailService emailService;
      @Autowired
     ConfirmationTokenService confirmationTokenService;

    public void resetPassword(ResetPasswordRequest resetPasswordRequest) {
        UserCredentials userCredentials = userCredentialsRepository.findByEmail(resetPasswordRequest.getEmailId()).get();

        if(userCredentialsService.isEmailIdExist(resetPasswordRequest.getEmailId()))
        {
            String token = userCredentialsService.getToken(userCredentials);
            String link = "http://localhost:5000/api/v1/resetpassword/confirm?token=" + token;
            emailSender.ResentPwdSend(
                    resetPasswordRequest.getEmailId(),
                    emailService.buildResetPasswordEmail("User", link));
        }

    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);

        return confirmationToken.getAppUser().getEmail();

    }
    public void updatePassword(UpdatePassword updatePassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(updatePassword.getNewPwd());

        //UserCredentials userCredentials = userCredentialsRepository.findByEmail(resetPasswordRequest.getEmailId()).get()
        UserCredentials userCredentials = userCredentialsRepository.findByEmail(updatePassword.getEmailId()).get();
        userCredentials.setPassword(encodedPassword);
        userCredentials.setResetpasswordtoken(null);
        userCredentialsRepository.save(userCredentials);
    }
}
