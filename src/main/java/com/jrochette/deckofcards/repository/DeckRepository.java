package com.jrochette.deckofcards.repository;

import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.exceptions.*;

public interface DeckRepository {
  public String save(Deck deck);

  public Deck fetch(String id) throws DeckDoesNotExistException, InvalidParameterException;

  public void remove(String id) throws InvalidParameterException;
}
