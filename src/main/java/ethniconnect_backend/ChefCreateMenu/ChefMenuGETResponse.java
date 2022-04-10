package ethniconnect_backend.ChefCreateMenu;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
@Data
public class ChefMenuGETResponse {

    private long login_id;
    private int cuisine_id;
    private MenuCategories menucategories;
    private String menu_item_image;
    private String item_name;
    private double menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    private  Week week;


}
