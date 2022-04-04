package ethniconnect_backend.ContactPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/ContactRequest")
    public String addcontactrequest(@RequestBody Contact contact)
    {

        contactService.saveContactRequest(contact);
        return "request added";
    }

    @GetMapping({"/ContactRequests"})
    public List<Contact> findcontactrequests()

    {
        return contactService.getContactRequets();
    }

    @GetMapping({"/ContactRequestById/{id}"})
    public Contact findcontactrequestbyId(@PathVariable int id)
    {
        return contactService.getContactRequestById(id);
    }

}
