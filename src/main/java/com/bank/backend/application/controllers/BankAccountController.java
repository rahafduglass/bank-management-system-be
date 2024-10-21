package com.bank.backend.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BankAccountController {

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
