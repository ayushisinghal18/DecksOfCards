package deckofcards.elements;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void addCardInHand(Card card) {
		hand.add(card);
	}

	public List<Card> getCards() {
		return hand;
	}

	public void clearHand() {
		hand.clear();
	}

}
