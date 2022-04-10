package ethniconnect_backend.Login;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginResponse {
    private long loginId;
    private boolean isChef;
    private boolean isCustomer;
    private String errormessage;

}
