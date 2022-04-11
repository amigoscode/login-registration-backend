package ethniconnect_backend.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/order/{orderid}")
    public ResponseEntity<Orders> getOrder(@PathVariable int orderid)
    {

        return new ResponseEntity<Orders>(orderService.getOrder(orderid), HttpStatus.OK);
    }
}
