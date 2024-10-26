package com.bank.backend.domain.services;

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

    public Card createCard(Card card) {
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());
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

// create card endpoint :
// roles             -> same account can't have the same type of card twice
// request(dto)      -> bankAccountId, cardType  DEBIT, CREDIT
// response          -> cardId, cardNumber
// filled by service -> createdAt, updated_at, status
// generated         -> expiryDate, cvv, cardNumber

}
