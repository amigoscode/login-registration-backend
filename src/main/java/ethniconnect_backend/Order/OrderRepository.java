package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByLogin_idOrderByCreatedDateDesc(Long login_id);

    //Optional<Order> findOrderById(Integer id);
}
