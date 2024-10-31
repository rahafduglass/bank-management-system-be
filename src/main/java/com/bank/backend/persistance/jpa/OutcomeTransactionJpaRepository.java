package com.bank.backend.persistance.jpa;

import com.bank.backend.domain.enums.TransactionStatus;
import com.bank.backend.persistance.entity.OutcomeTransactionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OutcomeTransactionJpaRepository extends JpaRepository<OutcomeTransactionEntity,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE outcome_transaction it SET it.status = :transactionStatus, it.updatedAt = :currentTime WHERE it.id = :id")
    void updateStatus(@Param("id") Long id,
                      @Param("currentTime") LocalDateTime currentTime,
                      @Param("transactionStatus") TransactionStatus transactionStatus);
}
