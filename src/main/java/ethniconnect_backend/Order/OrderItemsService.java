package ethniconnect_backend.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public void addOrderedProducts(OrderItem orderItem) {
        Orders order = new Orders();
        //orderItem.setOrderid(order.getOrderid());
        orderItemsRepository.save(orderItem);
    }
}