package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Setter
@Entity (name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue
    private int orderitemid;
    private int menu_id;
    private String special_instructions;
    private int quantity;
    private int orderid;

    @ManyToOne
    @JoinColumn(name = "menu_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ChefMenu chefMenu;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "orderid",insertable = false,updatable = false)
//    private Orders order;
//
//
//    public void setOrder(Orders order) {
//        this.order = order;
//    }
//
//    public Orders getOrder(Orders order) {
//        this.order = order;
//        return this.order;
//    }


}

