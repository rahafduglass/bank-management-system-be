package com.bank.backend.application.controllers;

import com.bank.backend.application.dtos.card.CreateCardRequest;
import com.bank.backend.application.dtos.card.CreateCardResponse;
import com.bank.backend.application.dtos.card.UpdateCardRequest;
import com.bank.backend.domain.enums.CardStatus;
import com.bank.backend.domain.mapper.CardMapper;
import com.bank.backend.domain.model.Card;
import com.bank.backend.domain.services.CardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable Long id){
        return ResponseEntity.ok(cardService.getCard(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardStatus> setCardStatus(@PathVariable Long id,@RequestParam CardStatus cardStatus){
        return ResponseEntity.ok(cardService.setCardStatus(id,cardStatus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCardInfo(@PathVariable Long id, @RequestBody UpdateCardRequest updateCardRequest){
        Card card= cardMapper.requestToModel(updateCardRequest);
        return ResponseEntity.ok(cardService.updateCardInfo(id,card));
    }
}
//check "in setCardStatus" for the expiryDate before updating the status


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


