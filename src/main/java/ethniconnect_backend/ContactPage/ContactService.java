package ethniconnect_backend.ContactPage;

import ethniconnect_backend.ChefSignup.ChefSignupRequest;
import ethniconnect_backend.ChefSignup.EmailValidator;
import ethniconnect_backend.ChefSignup.token.ConfirmationTokenService;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import ethniconnect_backend.UserCredentials.UserRole;

import ethniconnect_backend.email.EmailSender;
import ethniconnect_backend.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    private final UserCredentialsService userCredentialsService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    private EmailService emailService;

    @Autowired
    public ContactRepository contactRepository;

   /* public Contact saveContact(Contact contact)
    {
        return contactRepository.save(contact);
    }*/


    public void saveContactRequest(String email, String name, String message) {
        boolean isValidEmail = emailValidator.
                test(email);

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }


        /*String link = "www.google.com";*/
        Contact contact = new Contact();
        contact.setEmailid(email);
        contact.setMessage(message);
        contact.setName(name);
        contactRepository.save(contact);
        emailSender.send(
                "ethniconnect@gmail.com",
                emailService.buildContactEmail(message,email));
        contactRepository.save(contact);

        //return token;
    }


    public List<Contact> getContactRequets()
    {
        return contactRepository.findAll();
    }
    public Contact getContactRequestById(int id)
    {
        return  contactRepository.findById(id).orElse(null);
    }

}
