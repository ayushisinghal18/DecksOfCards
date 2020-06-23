package deckofcards.elements;

import java.util.ArrayList;
import java.util.List;

public class Shoe {

	private List<List<Card>> cards;
	private int numberOfDecks;

	public Shoe(int number) {
		this.numberOfDecks = number;
	}

	private void createShoe() {
		this.cards = new ArrayList<List<Card>>();
		
		for (int i = 0; i < this.numberOfDecks; i++) {
			cards.add(new Deck().getCards());
		}
	}
	
	private void shuffle() {
		int cardCount = cards.size();
	}
}
