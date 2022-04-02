package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.*;
import ethniconnect_backend.ChefCreateMenu.OrderRequest;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order")
    public ResponseEntity<String> addOrder(@RequestBody OrderRequest orderRequest) throws Exception
    {

        //chefMenuService.saveChefMenu(ch);
        orderService.saveOrder(orderRequest);

        return new ResponseEntity<>("order is places successfully", HttpStatus.OK);
    }
   /* @PostMapping("/chefs")
    public List<Chef> addChefs(@RequestBody List<Chef> chefs)
    {
        return chefProfileService.saveChefs(chefs);
    }*/

    @GetMapping({"/getOrderById/{id}"})
    public Order findOrderById(@PathVariable int id)
    {
        return orderService.getOrderById(id);
    }

    @PutMapping("/updateorder")
    public Order updateOrder(@RequestBody Order order)
    {
        return orderService.updateOrder(order);
    }
}




