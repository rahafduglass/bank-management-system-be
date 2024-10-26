package com.bank.backend.application.controllers;

import com.bank.backend.application.dtos.card.CreateCardRequest;
import com.bank.backend.application.dtos.card.CreateCardResponse;
import com.bank.backend.domain.mapper.CardMapper;
import com.bank.backend.domain.model.Card;
import com.bank.backend.domain.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/cards")
@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    @PostMapping
    public ResponseEntity<CreateCardResponse> createCard(@RequestBody CreateCardRequest createCardRequest) {
        Card card = cardMapper.requestToModel(createCardRequest);
        return ResponseEntity.ok(cardMapper.modelToResponse(cardService.createCard(card)));
    }

}
// create card endpoint :
// roles             -> same account can't have the same type of card twice
// request(dto)      -> bankAccountId, cardType  DEBIT, CREDIT
// response          -> cardId, cardNumber
// filled by service -> createdAt, updated_at, status
// generated         -> expiryDate, cvv, cardNumber


// get card endpoint :
// request      ->  id (path variable)
// response     -> card model


// set card status endpoint : ACTIVE,  CLOSED


// renew card info endpoint :
// roles        -> new generate expiry date, cvv, cardNumber.


