package ethniconnect_backend.Order;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.CustomerDetails.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@Transactional
public class Orders {

    @Id
    @GeneratedValue
    private int orderid;
    private LocalDateTime order_date;
    private double order_amount;
    private long cust_loginid;



    @OneToMany
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable = false, updatable = false)
    private   List<OrderItem> orderItems = new ArrayList<>();



    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_loginid", referencedColumnName = "loginid", insertable = false, updatable = false)
    private Customer customer;*/


//    public void addOrderItems(OrderItem orderItem) {
//        orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }

  /*  public void removeOrderItems(OrderItem orderItem) {
        orderItems.remove(orderItem);
        orderItem.setOrder(null);
    }*/



}
