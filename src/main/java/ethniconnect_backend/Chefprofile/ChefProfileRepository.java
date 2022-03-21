package ethniconnect_backend.Chefprofile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefProfileRepository extends JpaRepository <Chef, Integer> {



    /*Chef findByEmailId(String chef_emailid);*/
}
