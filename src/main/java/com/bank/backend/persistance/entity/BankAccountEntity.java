package com.bank.backend.persistance.entity;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "bank_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "bank_account")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="account_type")
    private AccountType accountType;

    @Column(name="balance")
    private BigDecimal balance;

    @Column(name="status")
    private AccountStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "bank_account")
    private Set<CardsEntity> cards;

    @OneToMany(mappedBy = "bank_account")
    private Set<IncomeTransactionEntity> incomeTransactions;

    @OneToMany(mappedBy = "bank_account")
    private Set<OutcomeTransactionEntity> outcomeTransactions;


    @ManyToOne
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private SysUserEntity user;

}
