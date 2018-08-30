package com.jrochette.deckofcards.cards.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeckDoesNotExistException extends Exception {
  private static final long serialVersionUID = 10941084855943871L;

  public DeckDoesNotExistException(String deckId) {
    super("Deck '" + deckId + "' does not exist");
  }


}
