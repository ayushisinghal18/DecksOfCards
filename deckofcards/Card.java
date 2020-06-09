package deckofcards;

import deckofcards.enums.CardSuit;

public class Card {

	private CardSuit suit;
	private int cardValue;

	public Card(CardSuit suit, int cardValue) {
		this.suit = suit;
		this.cardValue = cardValue;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public int getCardValue() {
		return cardValue;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", cardValue=" + cardValue + "]";
	}
	
	

}
