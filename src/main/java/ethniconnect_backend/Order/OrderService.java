package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.*;
import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.ChefDetails.ChefRepository;
import ethniconnect_backend.ChefSignup.EmailValidator;
import ethniconnect_backend.ChefSignup.token.ConfirmationTokenService;
import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.CustomerDetails.Customer;
import ethniconnect_backend.CustomerDetails.CustomerRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailSender emailSender;

    @Autowired
    private ChefMenuRepository chefMenuRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    private CustomerRepository customerRepository;
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

    public Integer placeOrder(OrderRequest orderRequest) {



        /*String link = "www.google.com";*/






        Orders order = new Orders();

        //orderRequest.setOrderid(order.getOrderid());
        order.setOrder_amount(orderRequest.getTotalprice());
        //order.setChef_loginid(orderRequest.getChefLoginid());
        order.setCust_loginid(orderRequest.getCustomerLoginid());
        order.setOrderItems(orderRequest.getOrderItems());

        order.setOrder_date(LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC));
        //order.setId(1);
        Orders savedOrder = orderRepository.save(order);
        Optional <Customer> customer = customerRepository.findByLoginid(orderRequest.getCustomerLoginid());

        String chefEmailId=null;
        for(OrderItem orderItem:orderRequest.getOrderItems())
        {
            orderItem.setOrderid(savedOrder.getOrderid());
            orderItemsRepository.save(orderItem);
        }

          //savedOrder = getOrder(savedOrder.getOrderid());
        //Optional <Chef> chef = chefRepository.findByLoginid(savedOrder.getOrderItems().get(0).getChefMenu().getChef().getLoginid());

        emailSender.orderRequest(
                "ethniconnect@gmail.com",
                //orderRepository.findByOrderid(orderid).get().getOrderItems().get(0).getChefMenu().getChef().getChef_emailid(),
                emailService.buildOrderRequestEmail(savedOrder.getOrderid(),
                        customer.get().getCust_emailid(),
                        savedOrder.getOrderItems().toString()));

                return savedOrder.getOrderid();



    }

    public Orders getOrder(int orderid) {

        Orders order=  orderRepository.findByOrderid(orderid).get();
        return order;
    }


}