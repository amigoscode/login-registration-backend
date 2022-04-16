package ethniconnect_backend.ChefDetails;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefRepository extends JpaRepository <Chef, Integer> {

    Optional<Chef> findByLoginid(long login_id);

    /*    *//*@Query("SELECT new ethniconnect_backend.ChefDetails.ChefprofileResponse( c.chef_fname, m.menu_item_price)" +
            " FROM Chef c join c.ChefMenu m")*//*
    public List<ChefprofileResponse> getChefProfileInfo();*/

}
