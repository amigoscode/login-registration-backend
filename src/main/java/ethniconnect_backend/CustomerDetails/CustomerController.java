package ethniconnect_backend.CustomerDetails;


import ethniconnect_backend.ChefDetails.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin()

@RestController
public class CustomerController {

    @Autowired
   private CustomerService customerService;

    @PostMapping("/customer")

    public String addcustomer(@RequestParam("file") MultipartFile file,
                          @RequestParam("cust_fname") String fname,
                          @RequestParam("cust_lname") String lname,
                          @RequestParam("cust_emailid") String emailid,
                          @RequestParam("cust_phone") String phone,
                          @RequestParam("cust_street") String street,
                          @RequestParam("cust_city") String city,
                          @RequestParam("cust_state") String state,
                          @RequestParam("cust_zip") String zip
                          ) throws Exception {
        customerService.saveCustomer(file, fname, lname,emailid,phone,street,
                city,state,zip);
        return "customer details added";
    }

   /* public Customer addCustomer(@RequestBody Customer customer) throws Exception
    {

        return customerService.saveCustomer(customer);
    }
*/

    @GetMapping({"/custById/{id}"})
    public Customer findCustById(@PathVariable int id)
    {
        return customerService.getCustById(id);
    }

    @GetMapping({"/custByLoginId/{id}"})

    public Customer findCustomerByLoginId(@PathVariable int id) {
        Long loginidlong = new Long(id);
        return customerService.getCustomerByLoginId(id);
    }


    @PutMapping("/updatecust")
    public Customer updateCust(@RequestBody Customer customer)
    {
        return customerService.updateCust(customer);
    }
}
