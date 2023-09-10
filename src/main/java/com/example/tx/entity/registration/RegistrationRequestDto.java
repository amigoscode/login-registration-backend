package com.example.tx.entity.registration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegistrationRequestDto {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String recaptchaResponse;

}