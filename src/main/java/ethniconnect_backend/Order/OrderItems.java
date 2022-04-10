package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.MenuCategories;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue
    private int id;
    private MenuCategories menucategory;
    private String menu_item_name;
    private String menu_item_image;
    private String special_instructions;
    private double item_price;
    private int quantity;

}

