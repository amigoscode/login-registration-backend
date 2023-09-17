package com.example.tx.controller;

import com.example.tx.utils.CaptchaProperties;
import com.example.tx.entity.registration.RegistrationRequest;
import com.example.tx.entity.registration.RegistrationRequestDto;
import com.example.tx.service.CaptchaService;
import com.example.tx.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/signup")
@CrossOrigin
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final CaptchaProperties captchaProperties;
    private final CaptchaService captchaService;

    @PostMapping
    public String register(@RequestBody RegistrationRequestDto request) {
        System.out.println(request);
        // Verify reCAPTCHA response
        captchaService.processResponse(request.getRecaptchaResponse(), CaptchaService.REGISTER_ACTION);

        return registrationService.register(new RegistrationRequest(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword()));
    }

    @PostMapping(path = "/confirm/{token}")
    public String confirm(@PathVariable("token") String token) {
        return registrationService.confirmToken(token);
    }



}
