package com.example.tx.utils;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "google.recaptcha")
public class CaptchaProperties {
    private String secret;
    private String url;
    private double threshold;

}
