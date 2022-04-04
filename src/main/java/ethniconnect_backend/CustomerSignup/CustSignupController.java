package ethniconnect_backend.CustomerSignup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;





@CrossOrigin()
@RestController
//@RequestMapping
@AllArgsConstructor
public class CustSignupController {

    private final CustSignupService custSignupService;

    @PostMapping("api/v1/CustSignup")
    public void register(@RequestBody CustSignupRequest request) {
         custSignupService.register(request);
    }

    @GetMapping("api/v1/CustSignup/confirm")
    public String confirm(@RequestParam("token") String token) {
        return custSignupService.confirmToken(token);
    }


}
