package com.jrochette.deckofcards.api.controllers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import com.jrochette.deckofcards.cards.Card;
import com.jrochette.deckofcards.cards.Deck;
import com.jrochette.deckofcards.cards.DeckBuilder;
import com.jrochette.deckofcards.exceptions.DeckDoesNotExistException;
import com.jrochette.deckofcards.exceptions.InvalidParameterException;
import com.jrochette.deckofcards.repository.DeckRepository;

public class DeckControllerTest {
  private static final String DECK_ID = "magicTheGathering";

  private DeckBuilder deckBuilderMock = mock(DeckBuilder.class);
  private DeckRepository deckRepositoryMock = mock(DeckRepository.class);
  private Deck deck = new Deck();

  private DeckController deckController;

  @Before
  public void setup() {
    deckController = new DeckController(deckRepositoryMock, deckBuilderMock);
  }

  @Test
  public void canCreateANewDeck() throws Exception {
    when(deckBuilderMock.build()).thenReturn(deck);

    Deck returnedDeck = deckController.createNewDeck();

    assertNotNull(returnedDeck);
    verify(deckBuilderMock).build();
    verify(deckRepositoryMock).save(deck);
  }

  @Test
  public void canGetDeck() throws Exception {
    when(deckRepositoryMock.fetch(DECK_ID)).thenReturn(deck);

    Deck returnedDeck = deckController.getDeck(DECK_ID);

    assertEquals(returnedDeck, deck);
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void getDeckThrowsIfDeckDoesNotExist() throws Exception {
    when(deckRepositoryMock.fetch(anyString())).thenThrow(new DeckDoesNotExistException(""));

    deckController.getDeck(DECK_ID);
  }

  @Test(expected = InvalidParameterException.class)
  public void getDeckShouldThrowIfInvalidParameter() throws Exception {
    when(deckRepositoryMock.fetch(null)).thenThrow(new InvalidParameterException("", ""));

    deckController.getDeck(null);
  }

  @Test
  public void canShuffleDeck() throws Exception {
    Deck deckMock = mock(Deck.class);
    when(deckRepositoryMock.fetch(DECK_ID)).thenReturn(deckMock);

    deckController.shuffleDeck(DECK_ID);

    verify(deckMock).shuffle();
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void shuffleDeckThrowsIfDeckDoesNotExist() throws Exception {
    when(deckRepositoryMock.fetch(anyString())).thenThrow(new DeckDoesNotExistException(""));

    deckController.shuffleDeck(DECK_ID);
  }

  @Test(expected = InvalidParameterException.class)
  public void shuffleDeckShouldThrowIfInvalidParameter() throws Exception {
    when(deckRepositoryMock.fetch(null)).thenThrow(new InvalidParameterException("", ""));

    deckController.shuffleDeck(null);
  }

  @Test
  public void canGetOneCardFromDeck() throws Exception {
    when(deckRepositoryMock.fetch(DECK_ID)).thenReturn(deck);

    Card card = deckController.getOneCardFromDeck(DECK_ID);

    assertNotNull(card);
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void getOneCardFromDeckThrowsIfDeckDoesNotExist() throws Exception {
    when(deckRepositoryMock.fetch(anyString())).thenThrow(new DeckDoesNotExistException(""));

    deckController.getOneCardFromDeck(DECK_ID);
  }

  @Test(expected = InvalidParameterException.class)
  public void getOneCardFromDeckDeckShouldThrowIfInvalidParameter() throws Exception {
    when(deckRepositoryMock.fetch(null)).thenThrow(new InvalidParameterException("", ""));

    deckController.getOneCardFromDeck(null);
  }

}
