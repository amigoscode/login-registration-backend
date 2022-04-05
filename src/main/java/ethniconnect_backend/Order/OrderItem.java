package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orderitems")
public class OrderItem {
    @Id
    @GeneratedValue
    private int order_item_id;

    //private int menu_id;
     private int quantity;
     private double price;
     //private int order_id;
     private Date order_date;


    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "menu_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ChefMenu chefMenu;

}
