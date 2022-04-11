package ethniconnect_backend.Order;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.CustomerDetails.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue
    private int orderid;
    private LocalDateTime order_date;
    private double order_amount;
    private long cust_loginid;
    private long chef_loginid;


//    @OneToMany(mappedBy = "orders",cascade=CascadeType.ALL,orphanRemoval = true)
//    //
//    //@JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable = false, updatable = false)
//    private List<OrderItem> orderItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_loginid", referencedColumnName = "loginid", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chef_loginid", referencedColumnName = "loginid", insertable = false, updatable = false)
    private Chef chef;




}
