package deckofcards.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import deckofcards.enums.CardSuit;

public class Deck {

	private final int DECK_SIZE = 52;
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (int i = 2; i <= 10; i++) {
			for (CardSuit suit : CardSuit.values()) {
				this.cards.add(new Card(suit, String.valueOf(i)));
			}
		}

		for (CardSuit suit : CardSuit.values()) {
			this.cards.add(new Card(suit, "J"));
		}
		for (CardSuit suit : CardSuit.values()) {
			this.cards.add(new Card(suit, "Q"));
		}
		for (CardSuit suit : CardSuit.values()) {
			this.cards.add(new Card(suit, "K"));
		}
		for (CardSuit suit : CardSuit.values()) {
			this.cards.add(new Card(suit, "A"));
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	void shuffle(int n) {
		Random rand = new Random();

		for (int x = 0; x < n; x++) {
			int i = rand.nextInt(this.cards.size());
			int j = rand.nextInt(this.cards.size());

			Collections.swap(cards, i, j);
		}
	}

	Card deal() {
		Card card = null;
		if (cards.size() != 0) {
			card = cards.remove(cards.size() - 1);
		}

		return card;
	}

}
