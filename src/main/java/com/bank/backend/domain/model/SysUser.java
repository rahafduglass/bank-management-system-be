package com.bank.backend.domain.model;

import com.bank.backend.domain.enums.UserRole;
import com.bank.backend.domain.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;


    private String password;


    private String email;


    private String fullName;

    private String phoneNumber;


    private Long nationalId;


    private String nationality;


    private UserRole role;// enum


    private String dateOfBirth;


    private String address;


    private String createdAt;


    private String updatedAt;


    private UserStatus statue;



}
