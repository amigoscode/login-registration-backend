package ethniconnect_backend.Order;

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
    private int orderid;
    private double totalprice;
    private List<OrderItem> orderItems;

}


