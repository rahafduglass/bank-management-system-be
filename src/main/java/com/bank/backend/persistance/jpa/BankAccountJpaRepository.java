package com.bank.backend.persistance.jpa;

import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.persistance.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, Long> {
}
