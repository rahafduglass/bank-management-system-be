package com.bank.backend.application.dtos.bankaccount;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankAccountRequest {
    private AccountType accountType;

    private String countryCode;

    private String checkDigits;

    private String bankIdentifier;

    private String branchCode;

    private String currency; // Add the currency field

    private BigDecimal balance;

    private Long userId;
}
