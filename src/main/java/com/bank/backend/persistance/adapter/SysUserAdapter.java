package com.bank.backend.persistance.adapter;


import com.bank.backend.domain.model.SysUser;
import com.bank.backend.persistance.jpa.SysUserJpaRepository;
import com.bank.backend.persistance.repository.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SysUserAdapter implements SysUserRepository {
    private final SysUserJpaRepository sysUserJpaRepository;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserJpaRepository.findByUsername(username);
    }
}
