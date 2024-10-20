package com.bank.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeTransaction {

    private Long id;


    private Long amount;


    private String description;



    private LocalDateTime transactionDate;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;


    private Long bankAccountId;

}
