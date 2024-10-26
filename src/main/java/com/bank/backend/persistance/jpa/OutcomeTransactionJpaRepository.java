package com.bank.backend.persistance.jpa;

import com.bank.backend.persistance.entity.OutcomeTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeTransactionJpaRepository extends JpaRepository<OutcomeTransactionEntity,Long> {
}
