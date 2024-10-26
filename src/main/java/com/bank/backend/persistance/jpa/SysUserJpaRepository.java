package com.bank.backend.persistance.jpa;

import com.bank.backend.persistance.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserJpaRepository extends JpaRepository<SysUserEntity,Long> {
}
