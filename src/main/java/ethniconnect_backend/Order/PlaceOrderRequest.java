package ethniconnect_backend.Order;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PlaceOrderRequest {
    private int id;
    private @NotNull long login_id;
    private @NotNull double order_amount;

}
