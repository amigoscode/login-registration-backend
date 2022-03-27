package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "chefmenu")
public class ChefMenu {
    @Id
    @GeneratedValue
    private int id;
    private long login_id;
    @Enumerated(EnumType.STRING)
    private MenuCategories menucategories;
    //private int cuisine_id;
    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] menu_item_image;
    private int menu_item_price;
    private String item_ingredients;
    private String item_intresting_facts;
    @Enumerated(EnumType.STRING)
    private  Week week;

    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_id")
    private CuisineCategory cuisineCategory;

    /*@JoinTable(
            name = "selected_cuisines",
            joinColumns = @JoinColumn(name = "menu_item_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id"))
    Set<CuisineCategories> selectedCuisines;*/
   /* @OneToMany
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu_items", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("menu")
    private List<Story> storyList = new ArrayList<>();*/
}
