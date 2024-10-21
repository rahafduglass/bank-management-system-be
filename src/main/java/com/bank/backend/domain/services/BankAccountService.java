package com.bank.backend.domain.services;

import com.bank.backend.domain.enums.AccountStatus;
import com.bank.backend.domain.enums.AccountType;
import com.bank.backend.domain.model.BankAccount;
import com.bank.backend.persistance.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private static final String COUNTRY_CODE = "JO"; // Example: Jordan
    private static final String BANK_CODE = "0012";
    private static final HashSet<String> generatedIbans = new HashSet<>();


    public BankAccount createBankAccount(BankAccount bankAccount) {
        bankAccount.setCreatedAt(LocalDateTime.now());
        bankAccount.setUpdatedAt(LocalDateTime.now());
        bankAccount.setStatus(AccountStatus.ACTIVE);
        bankAccount.setAccountNumber(createAccountNumber());
        bankAccount.setIban(createIpanNumber());

    }

    public String createAccountNumber(){
        // Generate a timestamp component
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        // Generate a 6-digit random number
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000); // range: 100000 to 999999

        // Combine timestamp and random number to form the account number
        return timestamp + randomNumber;
    }

    public String createIpanNumber(){
        String iban;
        do {
            iban = generateIban();
        } while (!isUnique(iban)); // Ensure uniqueness by checking generated IBANs

        generatedIbans.add(iban); // Store the IBAN to track uniqueness
        return iban;
    }
}
// function that generate bank
// 1- account number &
// 2- iban
// each generated number must be unique

