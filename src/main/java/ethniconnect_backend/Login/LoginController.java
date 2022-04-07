package ethniconnect_backend.Login;

import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin()
@RestController
public class LoginController
{

    @Autowired
    public UserCredentialsRepository userCredentialsRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody UserCredentials userCredentials)
    {
        UserCredentials userCredentialsFromDB = userCredentialsRepository.findByEmail(userCredentials.getEmail()).get();
        LoginResponse loginResponse = new LoginResponse();
        if(userCredentials.getEmail().equals(userCredentialsFromDB.getEmail())
                && bCryptPasswordEncoder.matches(userCredentials.getPassword(),userCredentialsFromDB.getPassword())
                && (userCredentialsFromDB.getEnabled().booleanValue() ||  userCredentialsFromDB.getEnabled() == true))
        {
            //return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

            loginResponse.setLoginId(userCredentialsFromDB.getId());
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }
        loginResponse.setErrormessage("User credentials are wrong");
        if(!(userCredentialsFromDB.getEnabled().booleanValue() ||  userCredentialsFromDB.getEnabled() == true))
        {
            loginResponse.setErrormessage("Account not activated");
        }
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(loginResponse, HttpStatus.UNAUTHORIZED);
    }
}
