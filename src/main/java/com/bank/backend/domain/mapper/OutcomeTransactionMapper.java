package com.bank.backend.domain.mapper;

import com.bank.backend.domain.model.OutcomeTransactions;
import com.bank.backend.persistance.entity.OutcomeTransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OutcomeTransactionMapper {
    OutcomeTransactions entityToModel(OutcomeTransactionEntity outcomeTransactionsEntity) ;

}
