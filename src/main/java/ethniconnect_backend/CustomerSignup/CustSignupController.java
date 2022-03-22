package ethniconnect_backend.CustomerSignup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;






@RestController
@RequestMapping(path = "api/v1/CustSignup")
@AllArgsConstructor
public class CustSignupController {

    private final CustSignupService custSignupService;

    @PostMapping
    public String register(@RequestBody CustSignupRequest request) {
        return custSignupService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return custSignupService.confirmToken(token);
    }


}
