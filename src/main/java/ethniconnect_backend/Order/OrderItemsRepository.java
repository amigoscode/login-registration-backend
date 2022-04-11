package ethniconnect_backend.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {

}
