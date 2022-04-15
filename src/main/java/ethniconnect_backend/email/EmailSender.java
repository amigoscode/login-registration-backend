package ethniconnect_backend.email;

public interface EmailSender {
    void send(String to, String emailContent);
    void Contactsend(String to, String emailContent);
    void ResentPwdSend(String to, String emailContent);
    void emailChefOrderDetails(String to, String emailContent);

    void emailCustomerOrderDetails(String to, String emailContent);
}
