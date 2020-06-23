package deckofcards.calculator;

import java.util.HashMap;
import java.util.Map;

import deckofcards.elements.Card;
import deckofcards.elements.Hand;

public class ScoreCalculator {

	private Map<String, Integer> scores;
	private final int BLACKJACK = 21;

	public ScoreCalculator() {

		scores = new HashMap<>();

		scores.put("2", 2);
		scores.put("3", 3);
		scores.put("4", 4);
		scores.put("5", 5);
		scores.put("6", 6);
		scores.put("7", 7);
		scores.put("8", 8);
		scores.put("9", 9);
		scores.put("10", 10);
		scores.put("J", 10);
		scores.put("Q", 10);
		scores.put("K", 10);
		scores.put("A", 11);
	}

	public int getCardScore(Card card) {
		return scores.get(card.getCardValue());
	}

	public int getHandValue(Hand hand) {
		int score = 0;
		int numOfAces = 0;

		for (Card card : hand.getCards()) {
			if (card.getCardValue().equals("A"))
				numOfAces++;
			else
				score += getCardScore(card);
		}

		for (int i = 0; i < numOfAces; i++) {
			if (score + scores.get("A") > BLACKJACK)
				score += 1;
			else if (score + scores.get("A") < BLACKJACK)
				score += scores.get("A");

		}

		if (score == BLACKJACK && hand.getCards().size() == 2)
			score = BLACKJACK;

		return score;
	}
}
