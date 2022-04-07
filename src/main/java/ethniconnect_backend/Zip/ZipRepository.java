package ethniconnect_backend.Zip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends JpaRepository<Zip,Integer> {
}
