package com.jrochette.deckofcards.repository;

import java.util.*;
import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.exceptions.*;

public class InMemoryDeckRepository implements DeckRepository {

  private final Map<String, Deck> decks = new HashMap<>();

  @Override
  public String save(Deck deck) {
    if (deck == null) {
      throw new IllegalArgumentException("deck should not be null");
    }
    decks.put(deck.getId(), deck);
    return deck.getId();
  }

  @Override
  public Deck fetch(String id) throws DeckDoesNotExistException, InvalidParameterException {
    validateId(id);

    Deck deck = decks.get(id);
    if (deck == null) {
      throw new DeckDoesNotExistException(id);
    }
    return decks.get(id);
  }

  @Override
  public void remove(String id) throws InvalidParameterException {
    validateId(id);

    decks.remove(id);
  }

  private void validateId(String id) throws InvalidParameterException {
    if (id == null) {
      throw new InvalidParameterException("id", "cannot be null");
    }
  }
}
