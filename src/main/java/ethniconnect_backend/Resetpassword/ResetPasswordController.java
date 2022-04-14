package ethniconnect_backend.Resetpassword;

import ethniconnect_backend.UserCredentials.UserCredentials;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
@CrossOrigin()
@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class ResetPasswordController {

    @Autowired
    ResetPasswordService resetPasswordService;

    @PostMapping(path="resetpassword")
    public  String restpassword(@RequestBody ResetPasswordRequest resetPasswordRequest)
    {
        resetPasswordService.resetPassword(resetPasswordRequest);
        return resetPasswordRequest.getEmailId();
    }

    @GetMapping(path = "/resetpassword/confirm")
    public RedirectView confirm(@RequestParam("token") String token) {
         String email=resetPasswordService.confirmToken(token);
        RedirectView redirectView = new RedirectView();
        String redirectUrl = "http://localhost:4200/resetpassword?email="+email;
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
