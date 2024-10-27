package com.bank.backend.domain.services;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.enums.TransactionStatus;
import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.domain.model.IncomeTransaction;
import com.bank.backend.persistance.repository.BankAccountRepository;
import com.bank.backend.persistance.repository.IncomeTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IncomeTransactionService {
    private final IncomeTransactionRepository incomeTransactionRepository;
    private final BankAccountRepository bankAccountRepository;

    public IncomeTransaction createIncomeTransaction(IncomeTransaction incomeTransaction) {
        incomeTransaction.setUpdatedAt(LocalDateTime.now());
        incomeTransaction.setTransactionDate(LocalDateTime.now());

        BankAccount bankAccount = bankAccountRepository.getById(incomeTransaction.getBankAccountId());
        if(bankAccount.getStatus() == AccountStatus.CLOSED || bankAccount.getStatus() == AccountStatus.FROZEN) {
            incomeTransaction.setStatus(TransactionStatus.FAILED);
        }else{
            incomeTransaction.setStatus(TransactionStatus.COMPLETED);
        }

        return incomeTransactionRepository.save(incomeTransaction);
    }

    public IncomeTransaction getIncomeTransactionById(Long id) {
        return  incomeTransactionRepository.getIncomeTransactionById(id);
    }

    public Page<IncomeTransaction> getAllIncomeTransactions(int page, int size, String sortBy, String sortDirection) {
        return incomeTransactionRepository.getAllIncomeTransactions( page, size, sortBy,  sortDirection);
    }

}
