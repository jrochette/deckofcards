package com.jrochette.deckofcards.cards;

import java.util.*;

public class Deck {
  private final String id;
  private List<Card> dealtCards;
  private Deque<Card> undealtCards;

  public Deck() {
    id = UUID.randomUUID().toString();
    dealtCards = new ArrayList<>();
    undealtCards = new ArrayDeque<>();
    for (Suit suit : Suit.values()) {
      for (FaceValue faceValue : FaceValue.values()) {
        undealtCards.push(new Card(suit, faceValue));
      }
    }
  }

  public Card dealOneCard() {
    if (undealtCards.isEmpty()) {
      return null;
    }

    Card dealtCard = undealtCards.pop();
    dealtCards.add(dealtCard);
    return dealtCard;
  }

  public void shuffle() {
    Random random = new Random();

    dealtCards.addAll(undealtCards);
    undealtCards = new ArrayDeque<>();

    while (!dealtCards.isEmpty()) {
      undealtCards.push(dealtCards.remove(random.nextInt(dealtCards.size())));
    }
  }

  public List<Card> getDealtCards() {
    return dealtCards;
  }

  public Deque<Card> getUndealtCards() {
    return undealtCards;
  }

  public String getId() {
    return id;
  }
}
