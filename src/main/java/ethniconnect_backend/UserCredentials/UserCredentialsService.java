package ethniconnect_backend.UserCredentials;

import ethniconnect_backend.ChefSignup.token.ConfirmationToken;
import ethniconnect_backend.ChefSignup.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Transactional
@Service
@AllArgsConstructor
public class UserCredentialsService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserCredentialsRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public boolean isEmailIdExist(String emailId)
    {
        if(appUserRepository.findByEmail(emailId).isPresent())
            return true;
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(UserCredentials inputUser) {

        Optional<UserCredentials> existingUserCredentials = appUserRepository.findByEmail(inputUser.getEmail());
        boolean userExists = appUserRepository
                .findByEmail(inputUser.getEmail())
                .isPresent();

        if (existingUserCredentials.isPresent() ) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            if(existingUserCredentials.get().isEnabled())
            {
                throw new IllegalStateException("email already taken");
            }
        }
        else
        {
            existingUserCredentials= Optional.of(inputUser);
        }


            String encodedPassword = bCryptPasswordEncoder
                    .encode(inputUser.getPassword());

           if(!existingUserCredentials.isPresent())
           {

           }
        existingUserCredentials.get().setPassword(encodedPassword);
        existingUserCredentials.get().setEmail(inputUser.getEmail());


            appUserRepository.save(existingUserCredentials.get());

        String token = getToken(existingUserCredentials.get());

//        TODO: SEND EMAIL

        return token;
    }

    public String getToken(UserCredentials appUser) {
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);
        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }


}
