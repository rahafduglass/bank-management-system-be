package com.bank.backend.application.controllers;

public class CardController {
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


