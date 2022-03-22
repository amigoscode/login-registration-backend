package ethniconnect_backend.resetpassword;

import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import ethniconnect_backend.ChefSignup.token.ConfirmationToken;
import ethniconnect_backend.ChefSignup.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ResetPasswordService {

    @Autowired
    UserCredentialsService appUserService;
    @Autowired
    UserCredentialsRepository appUserRepository;
    @Autowired
      EmailSender emailSender;
      @Autowired
      EmailService emailService;
      @Autowired
     ConfirmationTokenService confirmationTokenService;

    public void resetPassword(ResetPasswordRequest resetPasswordRequest) {
        UserCredentials userCredentials = appUserRepository.findByEmail(resetPasswordRequest.getEmailId()).get();

        if(appUserService.isEmailIdExist(resetPasswordRequest.getEmailId()))
        {
            String token =appUserService.getToken(userCredentials);
            String link = "http://localhost:5000/api/v1/resetpassword/confirm?token=" + token;
            emailSender.send(
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
}
