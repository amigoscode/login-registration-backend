package ethniconnect_backend.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public void addOrderedProducts(OrderItem orderItem) {
        Order order = new Order();
        orderItem.setOrder_id(order.getOrderid());
        orderItemsRepository.save(orderItem);
    }
}