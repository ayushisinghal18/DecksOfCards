package deckofcards.validators;

import java.util.ArrayList;
import java.util.List;

import deckofcards.elements.Card;
import deckofcards.enums.CardSuit;

public class CardValidator {

	private List<String> cardValue;

	public CardValidator() {
		// valid card face values
		cardValue = new ArrayList<>();
		cardValue.add("2");
		cardValue.add("3");
		cardValue.add("4");
		cardValue.add("5");
		cardValue.add("6");
		cardValue.add("7");
		cardValue.add("8");
		cardValue.add("9");
		cardValue.add("10");
		cardValue.add("J");
		cardValue.add("Q");
		cardValue.add("K");
		cardValue.add("A");
	}

	public boolean validateCard(Card card) {
		if (CardSuit.values().equals(card.getSuit())) {
			if (cardValue.contains(card.getCardValue())) {
				return true;
			}
		}
		return false;
	}

}
