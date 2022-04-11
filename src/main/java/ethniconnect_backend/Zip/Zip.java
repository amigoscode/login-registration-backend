package ethniconnect_backend.Zip;

import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zip {
    @Id
    private int id;
    private int zipCode;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ZIP_CUISINE", joinColumns = { @JoinColumn(name = "zip_id") },
            inverseJoinColumns = { @JoinColumn(name = "cuisine_id") })
    private Set<CuisineCategory> cuisineCategory;
}
