package com.jrochette.deckofcards.repository;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import com.jrochette.deckofcards.cards.*;
import com.jrochette.deckofcards.cards.exceptions.*;

public class InMemoryDeckRepositoryTest {

  @Test
  public void canSaveAndRetrieveDecks() throws Exception {
    InMemoryDeckRepository repository = new InMemoryDeckRepository();
    Deck deck = new Deck();

    String id = repository.save(deck);
    Deck fetchedDeck = repository.fetch(id);

    assertEquals(deck, fetchedDeck);
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void fetchShouldThrowExceptionIfDeckNotFound() throws Exception {
    InMemoryDeckRepository repository = new InMemoryDeckRepository();

    repository.fetch("Chewbaca");
  }

  @Test(expected = DeckDoesNotExistException.class)
  public void canRemoveDeckFromRepository() throws Exception {
    InMemoryDeckRepository repository = new InMemoryDeckRepository();
    Deck deck = new Deck();
    repository.save(deck);

    repository.remove(deck.getId());
    repository.fetch(deck.getId()); // This invocation should throw, as deck was removed
  }

}
