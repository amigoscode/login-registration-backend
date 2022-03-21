package ethniconnect_backend.resetpassword;

import ethniconnect_backend.appuser.AppUserRepository;
import ethniconnect_backend.appuser.AppUserService;
import ethniconnect_backend.appuser.UserCredentials;
import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import ethniconnect_backend.registration.token.ConfirmationToken;
import ethniconnect_backend.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ResetPasswordService {

    @Autowired
    AppUserService appUserService;
    @Autowired
    AppUserRepository appUserRepository;
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
                    emailService.buildEmail("User", link));
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
