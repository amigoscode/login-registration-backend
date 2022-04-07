package ethniconnect_backend.Zip;

import ethniconnect_backend.Cuisines.CuisineCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zip {
    @Id
    private int id;
    private int zipCode;
    @OneToMany
            @JoinColumn (name= "zip_id")
    Set<CuisineCategory> cuisineCategory;
}
