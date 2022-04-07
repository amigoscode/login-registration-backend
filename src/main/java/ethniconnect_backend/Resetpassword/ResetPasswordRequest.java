package ethniconnect_backend.Resetpassword;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@Setter
public class ResetPasswordRequest {

    private String emailId;
    @JsonCreator
    ResetPasswordRequest(@JsonProperty("emailId") String emailId) {
        this.emailId = emailId;
    }


}
