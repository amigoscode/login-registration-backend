package com.example.tx.entity.email;

public interface EmailSender {
    void send(String subject, String to, String email);
}
