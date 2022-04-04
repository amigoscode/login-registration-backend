package ethniconnect_backend.ChefSignup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
//@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class ChefSignupController {

    private final ChefSignupService registrationService;

    @PostMapping("api/v1/registration")
    public void register(@RequestBody ChefSignupRequest request) {
         registrationService.register(request);
    }

    @GetMapping("api/v1/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


 }
