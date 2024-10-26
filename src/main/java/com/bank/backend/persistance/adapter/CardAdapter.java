package com.bank.backend.persistance.adapter;

import com.bank.backend.domain.enums.CardStatus;
import com.bank.backend.domain.mapper.CardMapper;
import com.bank.backend.domain.model.Card;
import com.bank.backend.persistance.entity.CardEntity;
import com.bank.backend.persistance.jpa.CardJpaRepository;
import com.bank.backend.persistance.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class CardAdapter implements CardRepository {
    private final CardJpaRepository cardJpaRepository;
    private final CardMapper cardMapper;

    @Override
    public Card save(Card card) {
        CardEntity cardEntity = cardMapper.modelToEntity(card);
        return cardMapper.entityToModel(cardJpaRepository.save(cardEntity));
    }

    @Override
    public Card getCard(Long id) {
        return cardMapper.entityToModel(cardJpaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("id not found exception, id = "+ id)
        ));
    }

    @Override
    public CardStatus setCardStatus(Long id, CardStatus cardStatus) {
        cardJpaRepository.updateCardStatus(id, cardStatus, LocalDateTime.now());
        return getCard(id).getStatus();
    }

    @Override
    public Card updateCardInfo(Long id, Card card) {
        cardJpaRepository.updateCardInfo(id,card.getStatus(),card.getCardType(), LocalDateTime.now());
        return cardMapper.entityToModel(cardJpaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("id not found exception id= "+ id)
        ));
    }
}
