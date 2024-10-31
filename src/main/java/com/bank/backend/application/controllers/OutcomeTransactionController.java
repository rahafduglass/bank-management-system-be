package com.bank.backend.application.controllers;

import com.bank.backend.domain.mapper.OutcomeTransactionMapper;
import com.bank.backend.domain.model.OutcomeTransactions;
import com.bank.backend.domain.services.OutcomeTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/outcomeTransaction")
public class OutcomeTransactionController {
    private final OutcomeTransactionService outcomeTransactionService;
    private final OutcomeTransactionMapper outcomeTransactionMapper;
    @GetMapping("{/id}")
    public ResponseEntity<OutcomeTransactions> getOutcomeTransactions(@PathVariable Long id) {
        OutcomeTransactions outcomeTransactions= outcomeTransactionService.getOutcomeTransactions(id);
        return ResponseEntity.ok(outcomeTransactions);
    }
}

// process endpoint :
//+ roles   -> check account balance >= amount
//+ subtract transaction -> update balance by id three parameters(subtract or add(type), bankAccountId, amount)
//+ this function in bank account repository, mode for both income & outcome
//+ bank account should be ACTIVE
// request ->  amount, incomeMethods, description, currency, reference, bank Account id (dto)
// response->  status, id (dto)

// get transaction : @PathVariable (id)

// get all : @requestParam

// retry Transaction endpoint (for Rejected only)