package com.bank.backend.persistance.jpa;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.persistance.entity.BankAccountEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE bank_account b SET b.status = :accountStatus WHERE b.id = :id")
    void updateAccountStatusById(@Param("id") Long id, @Param("accountStatus") AccountStatus accountStatus);


    @Query("SELECT CASE WHEN COUNT(ba) > 0 THEN TRUE ELSE FALSE END " +
            "FROM bank_account ba WHERE ba.accountNumber = :accountNumber AND ba.status = 'ACTIVE'")
    Boolean isAccountActive(@Param("accountNumber") String accountNumber);

    @Modifying
    @Query("UPDATE bank_account b SET b.balance = :amount, b.updatedAt = :currentTime WHERE b.id = :id")
    void updateBalance(@Param("id") Long id,
                       @Param("amount") BigDecimal amount,
                       @Param("currentTime") LocalDateTime currentTime);

}
