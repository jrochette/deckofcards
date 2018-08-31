package com.jrochette.deckofcards.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends Exception {
  private static final long serialVersionUID = 1266011447848398693L;

  public InvalidParameterException(String parameterName, String cause) {
    super("'" + parameterName + "' is not valid. Cause: " + cause);
  }
}
