package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.Order.OrderItem;
import ethniconnect_backend.Order.OrderItemsRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class OrderRequest {

    private int order_id;
    private long login_id;

    List<OrderItemsRequest> orderItemsRequestList;

}


