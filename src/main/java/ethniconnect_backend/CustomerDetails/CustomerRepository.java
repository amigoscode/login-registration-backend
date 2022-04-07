package ethniconnect_backend.CustomerDetails;

import ethniconnect_backend.ChefDetails.ChefprofileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}