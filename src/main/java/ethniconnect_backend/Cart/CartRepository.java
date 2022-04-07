package ethniconnect_backend.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByLoginIdOrderByCreatedDateDesc(long login_id);


}
