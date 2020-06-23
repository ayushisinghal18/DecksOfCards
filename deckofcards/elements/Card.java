package deckofcards.elements;

import deckofcards.enums.CardSuit;

public class Card {

	private CardSuit suit;
	private String cardValue;

	public Card(CardSuit suit, String cardValue) {
		this.suit = suit;
		this.cardValue = cardValue;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public String getCardValue() {
		return cardValue;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", cardValue=" + cardValue + "]";
	}
	
	

}
