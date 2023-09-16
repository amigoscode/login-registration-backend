package com.example.tx.service;

import com.example.tx.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;


}
