package com.bank.backend.domain.services;

import com.bank.backend.domain.enums.CardStatus;
import com.bank.backend.domain.mapper.CardMapper;
import com.bank.backend.domain.model.Card;
import com.bank.backend.persistance.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public Card createCard(Card card) {
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());
        card.setStatus(CardStatus.ACTIVE);
        card.setCardNumber(generateCardNumber());
        card.setCvv(generateCvv());
        card.setExpiryDate(LocalDateTime.now().plusYears(4L));

        return cardRepository.save(card);
    }
    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));  // Generate a digit between 0-9
        }
        return cardNumber.toString();
    }

    private String generateCvv() {
        Random random = new Random();
        int cvv = 100 + random.nextInt(900);  // Generate a number between 100-999
        return String.valueOf(cvv);
    }

    public Card getCard(Long id) {
        return cardRepository.getCard(id);
    }

    public CardStatus setCardStatus(Long id, CardStatus cardStatus) {
        return cardRepository.setCardStatus(id,cardStatus);
    }
}
