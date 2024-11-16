package com.bank.backend.application.controllers;

import com.bank.backend.application.dtos.authentication.UserAuthenticationRequest;
import com.bank.backend.application.dtos.authentication.UserAuthenticationResponse;
import com.bank.backend.application.dtos.register.RegisterRequest;
import com.bank.backend.application.dtos.register.RegisterResponse;
import com.bank.backend.domain.mapper.RegisterMapper;
import com.bank.backend.domain.mapper.UserAuthenticationMapper;
import com.bank.backend.domain.model.SysUser;
import com.bank.backend.domain.services.IdmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/idm")
@RequiredArgsConstructor
public class IdmController {
    private final IdmService idmService;
    private final RegisterMapper registerMapper;
    private final UserAuthenticationMapper userAuthenticationMapper;


    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(registerMapper.modelToResponse(idmService.register(registerMapper.requestToModel(request))));
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest request){
        return ResponseEntity.ok(userAuthenticationMapper.modelToResponse(idmService.login(userAuthenticationMapper.requestToModel(request))));
    }

    @GetMapping("/{username}")
    public ResponseEntity<SysUser> getUserByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(idmService.getUserByUsername(username));
    }
}
