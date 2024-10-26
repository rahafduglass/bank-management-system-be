package com.bank.backend.persistance.repository;

import com.bank.backend.domain.enums.CardStatus;
import com.bank.backend.domain.model.Card;
import com.bank.backend.persistance.entity.CardEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository {
    Card save(Card card);

    Card getCard(Long id);

    CardStatus setCardStatus(Long id, CardStatus cardStatus);

    Card updateCardInfo(Long id, Card card);
}
