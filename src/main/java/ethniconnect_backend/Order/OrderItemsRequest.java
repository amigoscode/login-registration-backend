package ethniconnect_backend.Order;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderItemsRequest {

    private  double price;
    private  int quantity;
    private  int order_id;
    private  int menu_id;

}
