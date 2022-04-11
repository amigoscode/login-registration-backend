package ethniconnect_backend.Order;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Integer> {

    //Optional<Order> findOrderById(Integer id);
}
