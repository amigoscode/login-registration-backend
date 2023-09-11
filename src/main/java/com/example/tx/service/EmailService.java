package com.example.tx.service;

import com.example.tx.configuration.EmailProperties;
import com.example.tx.entity.email.EmailSender;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailService.class);
    private final JavaMailSender mailSender;
    private final EmailProperties emailProperties;

    @Override
    @Async
    public void send(String subject, String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom(emailProperties.getUsername());
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error(emailProperties.getErrorMessage(), e);
            throw new IllegalStateException(emailProperties.getErrorMessage());
        }
    }
}
