package ethniconnect_backend.ChefCreateMenu;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ChefMenuItem {

    @Enumerated(EnumType.STRING)
    private MenuCategories menucategories;
    private String menu_item_image;
    private String item_name;
    private double menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
}
