package ethniconnect_backend.Cuisines;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import ethniconnect_backend.Zip.Zip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuisinecategory")
public class CuisineCategory {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String cuisine_name;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String cuisine_image;

//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cuisineCategory")
//    private List<ChefMenu> menus;

}
