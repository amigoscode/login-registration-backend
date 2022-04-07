package ethniconnect_backend.ChefDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChefRepository extends JpaRepository <Chef, Integer> {

/*    *//*@Query("SELECT new ethniconnect_backend.ChefDetails.ChefprofileResponse( c.chef_fname, m.menu_item_price)" +
            " FROM Chef c join c.ChefMenu m")*//*
    public List<ChefprofileResponse> getChefProfileInfo();*/

}
