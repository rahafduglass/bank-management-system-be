package com.bank.backend.persistance.repository;

import com.bank.backend.domain.model.OutcomeTransactions;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeTransactionRepository {
    OutcomeTransactions getOutcomeTransactions(Long id);
}
