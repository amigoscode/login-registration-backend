package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity (name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue
    private int order_item_id;
    private int menu_id;
    private int order_id;
    private String special_instructions;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "orderid",insertable = false,updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "menu_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ChefMenu chefMenu;


}

