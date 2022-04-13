package ethniconnect_backend.ChefSignup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

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

  /* @GetMapping("api/v1/registration/confirm")
    public RedirectView confirm(@RequestParam("token") String token) {
        String email=registrationService.confirmToken(token);
        RedirectView redirectView = new RedirectView();
        String redirectUrl = "http://localhost:4200/chefloginsetup?email="+email;
        redirectView.setUrl(redirectUrl);*//*

        return redirectView;
    }*/

 }
