package ethniconnect_backend.Resetpassword;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Setter
public class UpdatePassword {
    private String emailId;
    private String newPwd;
}
