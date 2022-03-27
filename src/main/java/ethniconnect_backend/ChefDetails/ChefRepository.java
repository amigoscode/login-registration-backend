package ethniconnect_backend.ChefDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository <Chef, Integer> {



    /*Chef findByEmailId(String chef_emailid);*/
}
