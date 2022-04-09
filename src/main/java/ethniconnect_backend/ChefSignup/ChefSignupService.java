package ethniconnect_backend.ChefSignup;

import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserRole;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import ethniconnect_backend.ChefSignup.token.ConfirmationToken;
import ethniconnect_backend.ChefSignup.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ChefSignupService {

    private final UserCredentialsService userCredentialsService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    private EmailService emailService;

    public void register(String   email, String password) {
        boolean isValidEmail = emailValidator.
                test(email);

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }



        String token = userCredentialsService.signUpUser(
                new UserCredentials(
                        email,
                        password,
                        UserRole.BUSINESS

                )
        );

        /*String link = "www.google.com";*/
        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send(
               email,
                emailService.buildEmail("user", link));

        //return token;
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
        userCredentialsService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }





}
