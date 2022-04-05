/*
package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import ethniconnect_backend.ChefCreateMenu.ChefMenuRepository;
import ethniconnect_backend.ChefCreateMenu.ChefMenuRequest;
import ethniconnect_backend.ChefCreateMenu.OrderRequest;
import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.CustomerDetails.Customer;
import ethniconnect_backend.CustomerDetails.CustomerRepository;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import org.apache.maven.artifact.repository.Authentication;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {



    @Autowired
    private ChefMenuRepository chefMenuRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CuisineCategoriesRepository cuisineCategoriesRepository;
    @Autowired
    OrderRepository orderRepository;

    public  Order saveOrder(OrderRequest orderRequest) throws Exception {


        Optional<UserCredentials> userData = userCredentialsRepository.findById(orderRequest.getLogin_id());
        if (!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Customer customer = customerRepository.findById(orderRequest.getCust_id()).get();
        // Long loginId = userData.get().getId();
        if (customer == null)
            throw new Exception("Customer doesn't exist");
        Order order = new Order();
        orderRequest.setLogin_id(orderRequest.getLogin_id());
        orderRequest.setCust_id(orderRequest.getCust_id());
        orderRequest.setMenu_id(orderRequest.getMenu_id());
        orderRequest.setOrder_instructions(orderRequest.getOrder_instructions());
        orderRequest.setOrder_date(orderRequest.getOrder_date());
        orderRequest.setPickup_time(orderRequest.getPickup_time());
        orderRequest.setOrder_amount(orderRequest.getOrder_amount());
        orderRequest.setLogin_id(orderRequest.getLogin_id());
        return orderRepository.save(order);


    }
   */
/* public List<Order> saveOrders(List<Order> orders){
        return OrderRepository.saveAll(orders);
    }*//*


    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }
    public Order getOrderById(int order_id){
        return orderRepository.findById(order_id).orElse(null);
    }

    public String deleteorder(int order_id)
    {
        orderRepository.deleteById(order_id);
        return "order deleted " + order_id;
    }
    public Order updateOrder(Order order)
    {
        Order existingOrder=orderRepository.findById(order.getOrder_id()).orElse(null);
        existingOrder.setOrder_amount(order.getOrder_amount());
        existingOrder.setOrder_date(order.getOrder_date());
        existingOrder.setOrder_instructions(order.getOrder_instructions());
        existingOrder.setMenu_id(order.getMenu_id());
        existingOrder.setPickup_time(order.getPickup_time());
        existingOrder.setCust_id(order.getCust_id());

        return orderRepository.save(existingOrder);

    }
}


*/
