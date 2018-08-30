package com.jrochette.deckofcards.api.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.cards.exceptions.*;
import com.jrochette.deckofcards.repository.*;

@RestController
public class DeckController {

  @Autowired
  private DeckRepository deckRepository;

  @PostMapping("/decks")
  public Deck createNewDeck() {
    Deck deck = new Deck();
    deckRepository.save(deck);
    return deck;
  }

  @GetMapping("/decks/{id}")
  public Deck getDeck(@PathVariable String id) throws DeckDoesNotExistException {
    return deckRepository.fetch(id);
  }

  @PatchMapping("/decks/{id}")
  public Deck shuffleDeck(@PathVariable String id) throws DeckDoesNotExistException {
    Deck deck = deckRepository.fetch(id);
    deck.shuffle();
    return deck;
  }

  @GetMapping("/decks/{id}/card")
  public Card getOneCardFromDeck(@PathVariable String id) throws DeckDoesNotExistException {
    Deck deck = deckRepository.fetch(id);
    return deck.dealOneCard();
  }
}
