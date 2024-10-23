package com.bank.backend.application.controllers;

import com.bank.backend.application.dtos.bankaccount.CreateBankAccountRequest;
import com.bank.backend.application.dtos.bankaccount.CreateBankAccountResponse;
import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.mapper.BankAccountMapper;
import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.domain.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final BankAccountMapper bankAccountMapper;

    @PostMapping
    public ResponseEntity<CreateBankAccountResponse> createBankAccount(@RequestBody CreateBankAccountRequest request) {
        BankAccount bankAccount = bankAccountMapper.requestToModel(request);
        return ResponseEntity.ok(bankAccountMapper.modelToResponse(bankAccountService.createBankAccount(bankAccount)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBankAccount(@PathVariable Long id){
        return ResponseEntity.ok(bankAccountService.deleteBankAccount(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable Long id){ //bank id
        return ResponseEntity.ok(bankAccountService.getBankAccount(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateBankAccountStatus(@PathVariable Long id,@RequestParam AccountStatus status){
        return  ResponseEntity.ok(bankAccountService.updateBankAccountStatus(id, status));
    }
}

// about the system :
// primary account => one card DEBIT, one card CREDIT only (on primary account only)
// saving  account => no cards

// user can have one of each type account (primary, saving)
