package ethniconnect_backend.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {
        public List<OrderItem> findOrderItemByOrderid(int orderid);
}
