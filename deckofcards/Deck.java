package deckofcards;

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
		for (int i = 1; i <= 13; i++) {
			for (CardSuit suit : CardSuit.values()) {
				this.cards.add(new Card(suit, i));
			}
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
