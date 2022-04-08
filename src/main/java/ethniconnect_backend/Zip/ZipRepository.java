package ethniconnect_backend.Zip;

import ethniconnect_backend.Cuisines.CuisineCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ZipRepository extends JpaRepository<Zip,Integer> {

public Zip getZipByZipCode(int zipCode);
}
