package com.example.tx.entity.auth;

import com.example.tx.entity.user.AppUser;
import com.sun.mail.util.DefaultProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO
{
    private AppUser appUser;
    private String jwt;
}
