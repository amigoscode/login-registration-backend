package ethniconnect_backend.ChefDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chef",uniqueConstraints= {@UniqueConstraint(columnNames = {"chef_emailid","chef_phone"})})


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
    /*@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] chef_image;*/
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String chef_image;



   /* @OneToMany (targetEntity = ChefMenu.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cm_fk" , referencedColumnName = "login_id")
    private List<ChefMenu> chefmenus;*/

}
