package ethniconnect_backend.CustomerDetails;


import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    public void saveCustomer(MultipartFile file, String fname, String lname, String emailid,
                         String phone, String street, String city,
                         String state, String zip) throws Exception
    {
        Customer customer =new Customer();
        Optional<UserCredentials> userData = userCredentialsRepository.findByEmail(emailid);
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Long loginId = userData.get().getLoginid();

        customer.setLoginid(loginId);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            customer.setCust_image(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        customer.setCust_fname(fname);
        customer.setCust_lname(lname);
        customer.setCust_emailid(emailid);
        customer.setCust_city(city);
        customer.setCust_phone(phone);
        customer.setCust_street(street);
        customer.setCust_state(state);
        customer.setCust_city(city);
        customer.setCust_zip(zip);

        customerRepository.save(customer);
    }

    /*public Customer saveCustomer(Customer customer) throws Exception{
        Optional<UserCredentials> userData =appUserRepository.findByEmail(customer.getCust_emailid());
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Long loginId = userData.get().getId();

        customer.setLogin_id(loginId);
        return customerRepository.save(customer);
    }*/
    public List<Customer> saveChefs(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }

    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }
    public Customer getCustById(int cust_id){
        return customerRepository.findById(cust_id).orElse(null);
    }


    public Customer getCustomerByLoginId(long loginid) {

        Optional<Customer> customer = customerRepository.findByLoginid(loginid);
        return customer.get();
    }

    /*public Chef getChefByEmailId(String chef_emailid){
        return chefProfileRepository.findByEmailId(chef_emailid);
    }*/
    public String deleteCust(int cust_id)
    {
        customerRepository.deleteById(cust_id);
        return "customer removed !!" + cust_id;
    }
    public Customer updateCust(Customer customer)
    {
        Customer existingCustomer=customerRepository.findByLoginid(customer.getLoginid()).orElse(null);
        existingCustomer.setCust_fname(customer.getCust_fname()!=null?customer.getCust_fname():existingCustomer.getCust_fname());
        existingCustomer.setCust_lname(customer.getCust_lname()!=null?customer.getCust_lname():existingCustomer.getCust_lname());

        existingCustomer.setCust_phone(customer.getCust_phone()!=null?customer.getCust_phone():existingCustomer.getCust_phone());
        existingCustomer.setCust_emailid(customer.getCust_emailid()!=null?customer.getCust_emailid():existingCustomer.getCust_emailid());
        existingCustomer.setCust_street(customer.getCust_street()!=null?customer.getCust_street():existingCustomer.getCust_street());
        existingCustomer.setCust_city(customer.getCust_city()!=null?customer.getCust_city():existingCustomer.getCust_city());
        existingCustomer.setCust_state(customer.getCust_state()!=null?customer.getCust_state():existingCustomer.getCust_state());
        existingCustomer.setCust_zip(customer.getCust_zip()!=null?customer.getCust_zip():existingCustomer.getCust_zip());
        existingCustomer.setCust_image(customer.getCust_image()!=null?customer.getCust_image():existingCustomer.getCust_image());

        return customerRepository.save(existingCustomer);

    }
}