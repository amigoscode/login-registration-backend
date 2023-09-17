package com.example.tx.controller;

import com.example.tx.entity.auth.LoginRequestDTO;
import com.example.tx.entity.auth.LoginResponseDTO;
import com.example.tx.service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/login")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public LoginResponseDTO login(@RequestBody LoginRequestDTO body)
    {
        return authenticationService.login(body.getUsername(), body.getPassword());
    }

}
