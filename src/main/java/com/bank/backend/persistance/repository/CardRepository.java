package com.bank.backend.persistance.repository;

import com.bank.backend.domain.model.Card;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository {
    Card save(Card card);
}
