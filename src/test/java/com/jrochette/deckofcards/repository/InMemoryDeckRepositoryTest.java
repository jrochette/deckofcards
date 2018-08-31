package com.jrochette.deckofcards.repository;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.exceptions.*;

public class InMemoryDeckRepositoryTest {

  private InMemoryDeckRepository repository;

  @Before
  public void setup() {
    repository = new InMemoryDeckRepository();
  }

  @Test
  public void canSaveAndRetrieveDecks() throws Exception {
    Deck deck = new Deck();

    String id = repository.save(deck);
    Deck fetchedDeck = repository.fetch(id);

    assertEquals(deck, fetchedDeck);
  }

  @Test(expected = IllegalArgumentException.class)
  public void saveShouldThrowWhenSavingANullDeck() {
    repository.save(null);
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void fetchShouldThrowExceptionIfDeckNotFound() throws Exception {
    repository.fetch("Chewbaca");
  }

  @Test(expected = InvalidParameterException.class)
  public void fetchShouldThrowExceptionWhenIdIsNull() throws Exception {
    repository.fetch(null);
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void canRemoveDeckFromRepository() throws Exception {
    Deck deck = new Deck();
    repository.save(deck);

    repository.remove(deck.getId());
    repository.fetch(deck.getId()); // This invocation should throw, as deck was removed
  }

  @Test(expected = InvalidParameterException.class)
  public void removeShouldThrowExceptionWhenIdIsNull() throws Exception {
    repository.remove(null);
  }
}
