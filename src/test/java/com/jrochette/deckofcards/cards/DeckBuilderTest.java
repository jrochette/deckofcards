package com.jrochette.deckofcards.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

public class DeckBuilderTest {

  @Test
  public void canBuildDeck() throws Exception {
    DeckBuilder deckBuilder = new DeckBuilder();
    Deck deck = deckBuilder.build();
    assertNotNull(deck);
    assertEquals(Deck.class, deck.getClass());
  }

}
