package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ChefMenuRepository extends JpaRepository<ChefMenu,Integer> {
    List<ChefMenu> findAllByChef(Chef chef);

    List<ChefMenu> findAllByCuisineCategory_Id(int cuisineId);


}
