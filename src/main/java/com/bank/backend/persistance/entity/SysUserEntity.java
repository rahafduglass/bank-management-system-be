package com.bank.backend.persistance.entity;

import com.bank.backend.domain.enums.UserRole;
import com.bank.backend.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name="sys_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="sys_user")
public class SysUserEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="fullName", nullable = false)
    private String fullName;

    @Column(name="phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name="nationlId", nullable = false)
    private Long nationalId;

    @Column(name="nationality", nullable = false)
    private String nationality;

    @Column(name="role", nullable = false)
    private UserRole role;// enum

    @Column(name="date-of-birth", nullable = false)
    private String dateOfBirth;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="createdAt", nullable = false)
    private String createdAt;

    @Column(name="updatedAt")
    private String updatedAt;

    @Column(name="statue", nullable = false)
    private UserStatus statue;

    @OneToMany(mappedBy = "sys_user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BankAccountEntity> bankAccounts;

}
