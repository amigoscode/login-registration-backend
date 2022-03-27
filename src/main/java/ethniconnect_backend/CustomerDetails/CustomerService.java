package ethniconnect_backend.CustomerDetails;

import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class CustomerService {
        @Autowired
        private CustomerRepository customerRepository;
        @Autowired
        private UserCredentialsRepository appUserRepository;

        public Customer saveCustomer(Customer customer) throws Exception{
            Optional<UserCredentials> userData =appUserRepository.findByEmail(customer.getCust_emailid());
            if(!userData.isPresent())
                throw new Exception("user Id doesn't exist");
            Long loginId = userData.get().getId();

            customer.setLogin_id(loginId);
            return customerRepository.save(customer);
        }
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
            Customer existingCustomer=customerRepository.findById(customer.getCust_id()).orElse(null);
            existingCustomer.setCust_fname(customer.getCust_fname());
            existingCustomer.setCust_lname(customer.getCust_lname());
            existingCustomer.setCust_phone(customer.getCust_phone());
            existingCustomer.setCust_emailid(customer.getCust_emailid());
            existingCustomer.setCust_street(customer.getCust_street());
            existingCustomer.setCust_city(customer.getCust_city());
            existingCustomer.setCust_state(customer.getCust_state());
            existingCustomer.setCust_zip(customer.getCust_zip());
            existingCustomer.setCust_image(customer.getCust_image());
            return customerRepository.save(existingCustomer);

        }
    }
