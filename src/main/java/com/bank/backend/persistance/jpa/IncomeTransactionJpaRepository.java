package com.bank.backend.persistance.jpa;

import com.bank.backend.persistance.entity.IncomeTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTransactionJpaRepository extends JpaRepository<IncomeTransactionEntity,Long> {
}
