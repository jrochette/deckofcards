package com.jrochette.deckofcards.repository;

import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.cards.exceptions.*;

public interface DeckRepository {
  public String save(Deck deck);

  public Deck fetch(String id) throws DeckDoesNotExistException;

  public void remove(String id);
}
