package ethniconnect_backend.CustomerDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer",uniqueConstraints= {@UniqueConstraint(columnNames = {"cust_emailid","cust_phone"})})
public class Customer {
    @Id
    private long loginid;
    private String cust_fname;
    private String cust_lname;
    private String cust_emailid;
    private String cust_phone;
    private String cust_street;
    private String cust_city;
    private String cust_state;
    private String cust_zip;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String cust_image;
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Order> orders;*/
//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Order> orders;

}
