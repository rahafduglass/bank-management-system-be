package com.bank.backend.persistance.adapter;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.mapper.BankAccountMapper;
import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.persistance.entity.BankAccountEntity;
import com.bank.backend.persistance.jpa.BankAccountJpaRepository;
import com.bank.backend.persistance.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BankAccountAdapter implements BankAccountRepository {
    private final BankAccountJpaRepository bankAccountJpaRepository;
    private final BankAccountMapper bankAccountMapper;
    @Override
    public Boolean deleteById(Long id) {
        if(getById(id) == null) {
            return false;
        }
        bankAccountJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateAccountStatusById(Long id, AccountStatus accountStatus) {
        bankAccountJpaRepository.updateAccountStatusById(id, accountStatus);
        return true;
    }

    @Override
    public BankAccount getById(Long id) {
        return bankAccountMapper.entityToModel(bankAccountJpaRepository.findById(id).orElseThrow(
                ()->new RuntimeException("id not found")
        ));
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        BankAccountEntity bankAccountEntity= bankAccountMapper.ModelToEntity(bankAccount);
        return bankAccountMapper.entityToModel(bankAccountJpaRepository.save(bankAccountEntity));
    }


}
