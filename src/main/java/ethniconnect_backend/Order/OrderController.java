package ethniconnect_backend.Order;

import ethniconnect_backend.ChefCreateMenu.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Integer> placeOrder(@RequestBody OrderRequest orderRequest)
    {
        int orderid= orderService.placeOrder(orderRequest);
        return new ResponseEntity<Integer>(orderid, HttpStatus.OK);
    }
}
