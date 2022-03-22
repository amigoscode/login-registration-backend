package ethniconnect_backend.ChefSignup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class ChefSignupController {

    private final ChefSignupService registrationService;

    @PostMapping
    public String register(@RequestBody ChefSignupRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


 }
