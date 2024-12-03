package com.bank.backend;

import com.bank.backend.domain.enums.UserStatus;
import com.bank.backend.persistance.entity.SysUserEntity;
import com.bank.backend.persistance.jpa.SysUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendApplication {

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    
//    @Bean
    public CommandLineRunner initUsers(SysUserJpaRepository sysUserJpaRepository) {
        return args -> {
            SysUserEntity user = new SysUserEntity();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123"));
            user.setEmail("user@bank.com");
            user.setFullName("bank user");
            user.setPhoneNumber("0781111111");
            user.setNationalId(123456L);
            user.setNationality("JOR");
            user.setDateOfBirth("2006-06-06");
            user.setAddress("JOR");
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            user.setStatue(UserStatus.ACTIVE);

            sysUserJpaRepository.save(user);
        };
    }
}
