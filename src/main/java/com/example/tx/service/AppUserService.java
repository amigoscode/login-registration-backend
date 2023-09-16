    package com.example.tx.service;

    import com.example.tx.entity.user.AppUser;
    import com.example.tx.entity.registration.token.ConfirmationToken;
    import com.example.tx.repository.AppUserRepository;
    import lombok.AllArgsConstructor;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.context.annotation.Bean;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.UUID;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class AppUserService implements UserDetailsService {

        private final static String USER_NOT_FOUND_MSG =
                "user with email %s not found";

        private final AppUserRepository appUserRepository;

        private final PasswordEncoder bCryptPasswordEncoder;

        private final ConfirmationTokenService confirmationTokenService;


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            AppUser user = appUserRepository.findByUsername(username);

            if(user == null)
            {
                log.error("User not found in database");
                throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username));
            }else{
                log.info("User found in the database {}", username);
            }

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities()); // CHECK IF AUTHORITIES ARE PASSED CORRECTLY


        }

        public String signUpUser(AppUser appUser) {
            boolean userExists = appUserRepository
                    .findByUsername(appUser.getUsername())
                    != null;

            if (userExists) {
                // TODO check of attributes are the same and
                // TODO if email not confirmed send confirmation email.

                throw new IllegalStateException("email already taken");
            }

           String token = saveUser(appUser);

                //        TODO: SEND EMAIL

            return token;
        }

        public String saveUser(AppUser appUser)
        {
            String encodedPassword = bCryptPasswordEncoder
                    .encode(appUser.getPassword());

            appUser.setPassword(encodedPassword);

            appUserRepository.save(appUser);

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
