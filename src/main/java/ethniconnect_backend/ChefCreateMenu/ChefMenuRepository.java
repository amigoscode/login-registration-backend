package ethniconnect_backend.ChefCreateMenu;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ChefMenuRepository extends JpaRepository<ChefMenu,Integer> {

    //Optional<ChefMenu> findById(Integer id);
    //ChefMenu findByLogin_id(long chef_login_Id);
}
