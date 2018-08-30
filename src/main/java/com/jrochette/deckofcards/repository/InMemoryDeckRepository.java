package com.jrochette.deckofcards.repository;

import java.util.*;
import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.cards.exceptions.*;

public class InMemoryDeckRepository implements DeckRepository {

  private final Map<String, Deck> decks = new HashMap<>();

  @Override
  public String save(Deck deck) {
    decks.put(deck.getId(), deck);
    return deck.getId();
  }

  @Override
  public Deck fetch(String id) throws DeckDoesNotExistException {
    Deck deck = decks.get(id);
    if (deck == null) {
      throw new DeckDoesNotExistException(id);
    }
    return decks.get(id);
  }

  @Override
  public void remove(String id) {
    decks.remove(id);
  }

}
