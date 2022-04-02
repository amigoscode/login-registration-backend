package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class OrderRequest {

    private int order_id;
    private long login_id;
    private int cust_id;
    private int menu_id;
    private LocalDate order_date;
    private LocalDateTime pickup_time;
    private String order_instructions;
    private double order_amount;

}


