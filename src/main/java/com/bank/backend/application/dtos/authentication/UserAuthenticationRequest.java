package com.bank.backend.application.dtos.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticationRequest {
    private String username;

    private String password;

    private String otp;
}