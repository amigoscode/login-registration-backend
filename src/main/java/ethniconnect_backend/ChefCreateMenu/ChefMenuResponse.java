package ethniconnect_backend.ChefCreateMenu;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ChefMenuResponse {

    private  int menuid;
    private String  menucategory;
    private String  menu_item_image;
    private String  item_name;
    private double   menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    private String  week;
    private String  cuisineCategory;


}
