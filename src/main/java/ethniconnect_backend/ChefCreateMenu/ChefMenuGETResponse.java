package ethniconnect_backend.ChefCreateMenu;

import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefMenuGETResponse {
    List<ChefMenuResponse> chefMenuList;

   /* private long login_id;
    private int cuisine_id;
    private MenuCategories menucategories;
    private String menu_item_image;
    private String item_name;
    private double menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    private  Week week;*/


}
