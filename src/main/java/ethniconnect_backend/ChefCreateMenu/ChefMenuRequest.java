package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ChefMenuRequest {
    private int id;
    private long login_id;
    private List<ChefMenuItem> menu;
    private int cuisine_id;
    private String item_name;
    private int menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    @Enumerated(EnumType.STRING)
    private  Week week;


}
