package ethniconnect_backend.ChefDetails;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ChefRequest {
    private long login_id;
    private String chef_fname;
    private String chef_lname;
    private String chef_emailid;
    private String chef_phone;
    private String chef_street;
    private String chef_city;
    private String chef_state;
    private String chef_zip;
    private String chef_paymode;
    private String chef_description;
    private int chef_experience;
    private String chef_fblink;
    private String chef_linkdin;
    private String chef_image;
}
