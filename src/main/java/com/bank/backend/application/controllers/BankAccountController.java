package com.bank.backend.application.controllers;

import com.bank.backend.application.dtos.bankaccount.CreateBankAccountRequest;
import com.bank.backend.application.dtos.bankaccount.CreateBankAccountResponse;
import com.bank.backend.domain.mapper.BankAccountMapper;
import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.domain.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final BankAccountMapper bankAccountMapper;

    @PostMapping
    public ResponseEntity<CreateBankAccountResponse> createBankAccount(@RequestBody CreateBankAccountRequest request) {
        BankAccount bankAccount = bankAccountMapper.requestToModel(request);
        BankAccount bankAccount2 = bankAccountService.createBankAccount(bankAccount);
        CreateBankAccountResponse response = bankAccountMapper.modelToResponse(bankAccount2);

        return ResponseEntity.ok(response);
    }

}
// create bank account (check status) =>
// active and frozen return runtime error
// closed => delete the old one and create new one

// user cant update account type !

// delete bank account

// get bank account (CAN SEE BALANCE)
// bank account id (@path variable)

// change account bank status (ACTIVE, FROZEN, CLOSED) @requestParam


// about the system :
// primary account => one card DEBIT, one card CREDIT only (on primary account only)
// saving  account => no cards

// user can have one of each type account (primary, saving)
