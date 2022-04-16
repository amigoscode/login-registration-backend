package ethniconnect_backend.ContactPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin()
@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;
    @PostMapping("/ContactRequest")
    public void addcontactrequest(@RequestBody Contact contact)

    {
        contactService.saveContactRequest(contact);

        //return "request added";
    }

   /* @PostMapping("/ContactRequest")
    public void addcontactrequest(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("message") String message
                                    )
    {
        contactService.saveContactRequest(name,email,message);

        //return "request added";
    }*/

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
