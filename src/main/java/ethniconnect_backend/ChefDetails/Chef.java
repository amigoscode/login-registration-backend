package ethniconnect_backend.ChefDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue
    private int chef_id;
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
