package ethniconnect_backend.ContactPage;

import ethniconnect_backend.Chefprofile.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    public ContactRepository contactRepository;
    public Contact saveContact(Contact contact)
    {
        return contactRepository.save(contact);
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
