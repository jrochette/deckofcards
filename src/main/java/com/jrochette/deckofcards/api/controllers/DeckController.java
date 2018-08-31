package com.jrochette.deckofcards.api.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.exceptions.*;
import com.jrochette.deckofcards.repository.*;

@RestController
public class DeckController {

  private DeckRepository deckRepository;
  private DeckBuilder deckBuilder;

  @Autowired
  public DeckController(DeckRepository deckRepository, DeckBuilder deckBuilder) {
    this.deckRepository = deckRepository;
    this.deckBuilder = deckBuilder;
  }

  @PostMapping("/decks")
  public Deck createNewDeck() {
    Deck deck = deckBuilder.build();
    deckRepository.save(deck);
    return deck;
  }

  @GetMapping("/decks/{id}")
  public Deck getDeck(@PathVariable String id)
      throws DeckDoesNotExistException, InvalidParameterException {
    return deckRepository.fetch(id);
  }

  @PatchMapping("/decks/{id}")
  public Deck shuffleDeck(@PathVariable String id)
      throws DeckDoesNotExistException, InvalidParameterException {
    Deck deck = deckRepository.fetch(id);
    deck.shuffle();
    return deck;
  }

  @GetMapping("/decks/{id}/card")
  public Card getOneCardFromDeck(@PathVariable String id)
      throws DeckDoesNotExistException, InvalidParameterException {
    Deck deck = deckRepository.fetch(id);
    return deck.dealOneCard();
  }
}
