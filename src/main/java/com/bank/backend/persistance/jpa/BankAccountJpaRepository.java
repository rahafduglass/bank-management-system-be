package com.bank.backend.persistance.jpa;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.persistance.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, Long> {
    @Override
    void deleteById(Long id);

    void updateAccountStatusById(Long id, AccountStatus accountStatus);


    @Override
     BankAccountEntity  save(BankAccountEntity entity);
}
