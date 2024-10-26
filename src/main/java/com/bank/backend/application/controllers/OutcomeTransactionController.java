package com.bank.backend.application.controllers;

public class OutcomeTransactionController {
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