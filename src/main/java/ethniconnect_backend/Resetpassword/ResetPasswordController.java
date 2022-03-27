package ethniconnect_backend.Resetpassword;

import ethniconnect_backend.UserCredentials.UserCredentials;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class ResetPasswordController {

    @Autowired
    ResetPasswordService resetPasswordService;

    @PostMapping(path="resetpassword")
    public  void restpassword(@RequestBody ResetPasswordRequest resetPasswordRequest)
    {
        resetPasswordService.resetPassword(resetPasswordRequest);
    }

    @GetMapping(path = "/resetpassword/confirm")
    public RedirectView confirm(@RequestParam("token") String token) {
         String email=resetPasswordService.confirmToken(token);
        RedirectView redirectView = new RedirectView();
        String redirectUrl = "https://fullstackdeveloper.guru?email="+email;
        redirectView.setUrl(redirectUrl);

        return redirectView;
    }

    @PutMapping(path="updatepassword")
    public String updatepassword(@RequestBody UpdatePassword updatePassword)
    {
         resetPasswordService.updatePassword(updatePassword);
         return "Updated Password";
    }

}
