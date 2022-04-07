package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ChefMenuRequest {
    private int id;
    private long login_id;
    @Enumerated(EnumType.STRING)
    private MenuCategories menucategories;
    private int cuisine_id;
    private String menu_item_image;
    private String item_name;
    private int menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    @Enumerated(EnumType.STRING)
    private  Week week;


}
