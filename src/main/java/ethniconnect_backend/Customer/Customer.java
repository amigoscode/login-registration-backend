package ethniconnect_backend.Customer;

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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int cust_id;
    private long login_id;
    private String cust_fname;
    private String cust_lname;
    private String cust_emailid;
    private String cust_phone;
    private String cust_street;
    private String cust_city;
    private String cust_state;
    private String cust_zip;
    private String cust_ethnicity;
    private String cust_image;

}
