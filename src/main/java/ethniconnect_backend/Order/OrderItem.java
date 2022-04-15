package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity (name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue
    private int orderitemid;
    private int menu_id;
    private String special_instructions;
    private int quantity;
    private int orderid;
    private Time pickuptime;

    @ManyToOne
    @JoinColumn(name = "menu_id",insertable = false, updatable=false)
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

