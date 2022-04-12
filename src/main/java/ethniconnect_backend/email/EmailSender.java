package ethniconnect_backend.email;

public interface EmailSender {
    void send(String to, String email);
    void Contactsend(String to, String email);
    void ResentPwdSend(String to, String email);
}
