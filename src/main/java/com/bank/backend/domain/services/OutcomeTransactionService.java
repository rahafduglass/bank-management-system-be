package com.bank.backend.domain.services;

import com.bank.backend.domain.mapper.OutcomeTransactionMapper;
import com.bank.backend.domain.model.OutcomeTransactions;
import com.bank.backend.persistance.repository.OutcomeTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutcomeTransactionService {
    OutcomeTransactionRepository outcomeTransactionRepository;
    OutcomeTransactionMapper outcomeTransactionMapper;
    public OutcomeTransactions getOutcomeTransactions(Long id) {
        return outcomeTransactionRepository.getOutcomeTransactions(id);
    }
}
