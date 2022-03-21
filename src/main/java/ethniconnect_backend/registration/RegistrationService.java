package ethniconnect_backend.registration;

import ethniconnect_backend.appuser.UserCredentials;
import ethniconnect_backend.appuser.UserRole;
import ethniconnect_backend.appuser.AppUserService;
import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import ethniconnect_backend.registration.token.ConfirmationToken;
import ethniconnect_backend.registration.token.ConfirmationTokenService;
import ethniconnect_backend.resetpassword.ResetPasswordRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    private EmailService emailService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String token = appUserService.signUpUser(
                new UserCredentials(
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.BUSINESS

                )
        );

        /*String link = "www.google.com";*/
        String link = "http://localhost:5000/api/v1/registration/confirm?token=" + token;
        emailSender.send(
                request.getEmail(),
                emailService.buildEmail(request.getFirstName(), link));

        return token;
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
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }





}
