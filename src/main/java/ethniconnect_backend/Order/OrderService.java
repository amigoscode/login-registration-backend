package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.*;
import ethniconnect_backend.ChefDetails.ChefRepository;
import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Transactional
@Service
public class OrderService {
    @Autowired
    private ChefMenuRepository chefMenuRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    CuisineCategoriesRepository cuisineCategoriesRepository;
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;


    @Autowired
    OrderItemsService orderItemsService;
    @Transactional
    public Integer placeOrder(OrderRequest orderRequest) {

        Orders order = new Orders();

        //orderRequest.setOrderid(order.getOrderid());
        order.setOrder_amount(orderRequest.getTotalprice());
        order.setChef_loginid(orderRequest.getChefLoginid());
        order.setCust_loginid(orderRequest.getCustomerLoginid());
        //order.setOrderItems(orderRequest.getOrderItems());

        order.setOrder_date(LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC));
        //order.setId(1);
        Orders savedOrder = orderRepository.save(order);

        for(OrderItem orderItem:orderRequest.getOrderItems())
        {
            orderItem.setOrderid(savedOrder.getOrderid());
            orderItemsRepository.save(orderItem);
        }
         return savedOrder.getOrderid();



    }

    public Orders getOrder(int orderid) {

        return orderRepository.findByOrderid(orderid).get();
    }
}