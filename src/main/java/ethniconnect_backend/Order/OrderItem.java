package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Setter
@Entity (name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue
    private int orderitemid;
    private int menu_id;
    private int orderid;
    private String special_instructions;
    private int quantity;
//    @ManyToOne
//    @JoinColumn(name = "orderid",referencedColumnName = "orderid",insertable = false,updatable = false)
//   private Orders order;



    //@OneToOne
    @ManyToOne
    @JoinColumn(name = "menu_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ChefMenu chefMenu;

    @ManyToOne(fetch = FetchType.LAZY)

   @JoinColumn(name = "orderid",referencedColumnName = "orderid",insertable = false,updatable = false)
    //@JoinColumn  (name = "orderid",insertable = false,updatable = false)
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }
}

