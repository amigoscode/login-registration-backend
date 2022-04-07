package ethniconnect_backend.ContactPage;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class ContactEmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: Regex to validate email
        return true;
    }
}
