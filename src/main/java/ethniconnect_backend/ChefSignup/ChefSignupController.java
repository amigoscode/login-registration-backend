package ethniconnect_backend.ChefSignup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin()
@RestController
//@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class ChefSignupController {

    private final ChefSignupService registrationService;

    @PostMapping("api/v1/registration")
    public void register( @RequestParam("email") String  email,
                          @RequestParam("password") String password)
    {
         registrationService.register(email,password);
    }

    @GetMapping("api/v1/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


 }
