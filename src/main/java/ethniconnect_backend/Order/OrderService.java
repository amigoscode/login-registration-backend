package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.*;
import ethniconnect_backend.ChefCreateMenu.OrderRequest;
import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.ChefDetails.ChefRepository;
import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Optional;

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
    OrderItemsService orderItemsService;

    public Integer placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrder_amount(orderRequest.getTotalprice());
        order.setChef_loginid(orderRequest.getChefLoginid());
        order.setCust_loginid(orderRequest.getCustomerLoginid());
        order.setOrderItems(orderRequest.getOrderItems());
        order.setOrder_date(LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC));
        //order.setId(1);
        orderRepository.save(order);
        return 1;



    }
}