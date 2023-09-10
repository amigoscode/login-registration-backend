package com.example.tx.service;

import com.example.tx.configuration.CaptchaProperties;
import com.example.tx.entity.GoogleResponse;
import com.example.tx.exception.ReCaptchaInvalidException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Getter
@Setter
public class CaptchaService implements ICaptchaService {

    public static final String REGISTER_ACTION = "register";
    private final CaptchaProperties captchaProperties;
    private final RestOperations restTemplate;
    private final ReCaptchaAttemptService reCaptchaAttemptService;


    @Override
    public void processResponse(String recaptchaResponse, String action) {


        String verifyUrl =  captchaProperties.getUrl() +
                "?secret=" + captchaProperties.getSecret() +
                "&response=" + recaptchaResponse +
                "&threshold=" + captchaProperties.getThreshold();

        GoogleResponse googleResponse = restTemplate.getForObject(verifyUrl, GoogleResponse.class);
        if(!googleResponse.isSuccess() ){//|| !googleResponse.getAction().equals(action) || googleResponse.getScore() < captchaProperties.getThreshold()) {
            if(googleResponse.hasClientError()) {
                reCaptchaAttemptService.reCaptchaFailed(recaptchaResponse);
            }
            throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
        }
        reCaptchaAttemptService.reCaptchaSucceeded(recaptchaResponse);
    }
}
