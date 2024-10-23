package com.bank.backend.persistance.jpa;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.persistance.entity.BankAccountEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE bank_account b SET b.status = :accountStatus WHERE b.id = :id")
    void updateAccountStatusById(@Param("id") Long id, @Param("accountStatus") AccountStatus accountStatus);
}
