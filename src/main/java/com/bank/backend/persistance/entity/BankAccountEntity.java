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

    @Column(name="account_number",nullable = false, unique = true)
    private String accountNumber;

    @Column(name="account_type",nullable = false)
    private AccountType accountType;

    @Column(name="balance",nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private SysUserEntity user;

    @Column(name="status",nullable = false)
    private AccountStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "bank_account")
    private Set<CardsEntity> cards;

    @OneToMany(mappedBy = "bank_account")
    private Set<IncomeTransactionEntity> incomeTransactions;

    @OneToMany(mappedBy = "bank_account")
    private Set<OutcomeTransactionEntity> outcomeTransactions;
}
