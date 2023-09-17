package com.example.tx.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailProperties {
    private String username;
    private String errorMessage = "Failed to send email";
}
