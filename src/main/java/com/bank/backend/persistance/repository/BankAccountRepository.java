package com.bank.backend.persistance.repository;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.persistance.entity.BankAccountEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BankAccountRepository {
    Boolean deleteById(Long id);

    Boolean updateAccountStatusById(Long id, AccountStatus accountStatus);

    BankAccount getById(Long id);

    BankAccount createBankAccount(BankAccount bankAccount);

    Boolean isAccountActive(String accountNumber);

    void updateBalance(Long id, BigDecimal amount);
}
