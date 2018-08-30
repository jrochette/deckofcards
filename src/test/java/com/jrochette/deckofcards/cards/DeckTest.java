package com.jrochette.deckofcards.cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.*;
import java.util.stream.*;
import org.junit.*;
import com.google.common.collect.*;

public class DeckTest {

  @Test
  public void newDeckOfCardShouldHave52DifferentCards() throws Exception {
    Deck deck = new Deck();

    assertNotNull(deck);
    assertEquals(0, deck.getDealtCards().size());
    assertEquals(52, Sets.newHashSet(deck.getUndealtCards()).size());
  }

  @Test
  public void dealOnCardShouldReturnACardAMoveItToTheDealtCards() throws Exception {
    Deck deck = new Deck();

    Card card = deck.dealOneCard();

    assertNotNull(card);
    assertEquals(1, deck.getDealtCards().size());
    assertEquals(card, deck.getDealtCards().get(0));
    assertEquals(51, deck.getUndealtCards().size());
  }

  @Test
  public void dealOnCardShouldReturnNullIfAllCardsAreDealt() throws Exception {
    Deck deck = new Deck();

    IntStream.range(0, 52).forEach(ignored -> deck.dealOneCard());

    assertEquals(52, deck.getDealtCards().size());
    assertEquals(0, deck.getUndealtCards().size());
    assertNull(deck.dealOneCard());
  }

  @Test
  public void shuffleChangeTheCardsOrderInUndealtCards() throws Exception {
    Deck deck = new Deck();
    List<Card> orignalDeckOrder = Lists.newArrayList(deck.getUndealtCards());

    deck.shuffle();

    List<Card> shuffledDeckOrder = Lists.newArrayList(deck.getUndealtCards());
    assertNotEquals(orignalDeckOrder, shuffledDeckOrder);
  }

  @Test
  public void shuffleShouldMoveAllDealtCardsBackToUndealtCards() throws Exception {
    Deck deck = new Deck();

    deck.dealOneCard();
    deck.dealOneCard();
    deck.dealOneCard();
    deck.dealOneCard();

    assertEquals(4, deck.getDealtCards().size());
    assertEquals(48, deck.getUndealtCards().size());

    deck.shuffle();

    assertEquals(0, deck.getDealtCards().size());
    assertEquals(52, deck.getUndealtCards().size());
  }
}
