package ethniconnect_backend.Order;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderItemsRequest {
    private @NotNull double price;
    private @NotNull int quantity;
    private @NotNull int order_id;
    private @NotNull int menu_id;
}
