package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chefmenu")
public class ChefMenu {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private MenuCategories menucategories;
    //private int cuisine_id;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String menu_item_image;
    private String item_name;
    private double menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    @Enumerated(EnumType.STRING)
    private  Week week;
    private long loginid;

    //@ManyToOne
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private CuisineCategory cuisineCategory;
//    @ManyToMany(mappedBy = "menu_items")
//    Set<Order> orders;

    @ManyToOne
    @JoinColumn (name="loginid", insertable = false, updatable = false)
    private Chef chef;
    /*@JoinTable(
            name = "selected_cuisines",
            joinColumns = @JoinColumn(name = "menu_item_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id"))
    Set<CuisineCategories> selectedCuisines;*/


}
