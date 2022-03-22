package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.UserCredentials.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
public class ChefMenu {
    @Id
    @GeneratedValue
    private int menu_item_id;
    @Enumerated(EnumType.STRING)
    private MenuCategories menuCategories;
    private int chef_cuisine_id;
    private String menu_item_image;
    private int menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    @Enumerated(EnumType.STRING)
    private  Week week;

}
