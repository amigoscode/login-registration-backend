package ethniconnect_backend.CustomerDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class CustomerController {

    @Autowired
   private CustomerService customerService;

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) throws Exception
    {

        return customerService.saveCustomer(customer);
    }


    @GetMapping({"/custById/{id}"})
    public Customer findCustById(@PathVariable int id)
    {
        return customerService.getCustById(id);
    }

    @PutMapping("/updatecust")
    public Customer updateCust(@RequestBody Customer customer)
    {
        return customerService.updateCust(customer);
    }
}
