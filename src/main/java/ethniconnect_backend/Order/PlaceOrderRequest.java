package ethniconnect_backend.Order;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PlaceOrderRequest {
    private  int id;
    private  long cust_loginid;
    private  double totalPrice;

}
