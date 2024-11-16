package com.bank.backend.domain.services;

import com.bank.backend.application.exception.InvalidCredentialsException;
import com.bank.backend.domain.model.SysUser;
import com.bank.backend.domain.model.UserAuthentication;
import com.bank.backend.domain.services.security.JwtService;
import com.bank.backend.domain.services.security.SysUserDetailsService;
import com.bank.backend.persistance.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdmService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserRepository sysUserRepository;

    public UserAuthentication login(UserAuthentication userAuthentication) {
        Authentication authentication = getAuthenticationStatus(userAuthentication);
        if(authentication.isAuthenticated()) {
            updateSecurityContextHolder(authentication);
            return buildUserAuthentication(userAuthentication);
        }

        throw new InvalidCredentialsException("Bad credentials, username or password are incorrect");
    }

    private static void updateSecurityContextHolder(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserAuthentication buildUserAuthentication(UserAuthentication userAuthentication) {
        UserDetails user = sysUserDetailsService.loadUserByUsername(userAuthentication.getUsername());
        String token = jwtService.generateToken(user);
        userAuthentication.setToken(token);
        return userAuthentication;
    }

    private Authentication getAuthenticationStatus(UserAuthentication endUserAuthentication) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        endUserAuthentication.getUsername(),
                        endUserAuthentication.getPassword()
                )
        );
    }


    public SysUser getUserByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
