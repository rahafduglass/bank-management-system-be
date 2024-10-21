package com.bank.backend.application.dtos.bankaccount;

import com.bank.backend.domain.enums.AccountStatus;

public class UpdateBankAccountStatusRequest {
    private Long id;
    private AccountStatus accountStatus;
}
