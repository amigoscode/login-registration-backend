package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Order.OrderItem;
import lombok.*;

import java.util.List;
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderRequest {

    private long chefLoginid;
    private long customerLoginid;
    private double totalprice;
    private List<OrderItem> orderItems;

}


