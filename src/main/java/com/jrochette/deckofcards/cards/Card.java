package com.jrochette.deckofcards.cards;

public class Card {
  public Suit suit;
  public FaceValue faceValue;

  public Card(Suit suit, FaceValue faceValue) {
    this.suit = suit;
    this.faceValue = faceValue;
  }

  @Override
  public String toString() {
    return faceValue + " of " + suit;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    if (faceValue != other.faceValue)
      return false;
    if (suit != other.suit)
      return false;
    return true;
  }
}
