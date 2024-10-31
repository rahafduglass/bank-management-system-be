package com.bank.backend.persistance.adapter;


import com.bank.backend.domain.mapper.OutcomeTransactionMapper;
import com.bank.backend.domain.model.OutcomeTransactions;
import com.bank.backend.persistance.jpa.OutcomeTransactionJpaRepository;
import com.bank.backend.persistance.repository.OutcomeTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OutcomeTransactionAdapter implements OutcomeTransactionRepository {
    OutcomeTransactionJpaRepository outcomeTransactionJpaRepository;
    OutcomeTransactionMapper outcomeTransactionMapper;

    @Override
    public OutcomeTransactions getOutcomeTransactions(Long id) {
       return outcomeTransactionJpaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("id not found")
        );
    }
}
