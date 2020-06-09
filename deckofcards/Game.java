package deckofcards;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final int HAND_SIZE = 5;

	// private List<Card> wonPile;
	private Deck deck;
	private List<Player> players;

	public Game() {
		// wonPile = new ArrayList<>();

		deck = new Deck();

		players = new ArrayList<>();

		for (int id = 1; id <= 2; id++) {
			players.add(new Player(id));
		}
	}

	public void play() {
		deck.shuffle(20);

		System.out.println("Player 1 cards in hand:= " + players.get(0).getHand().size());
		System.out.println("Player 2 cards in hand:= " + players.get(1).getHand().size());

		for (int i = 0; i < HAND_SIZE; i++) {
			players.get(0).getHand().add(deck.deal());
			players.get(1).getHand().add(deck.deal());
		}

		for (Player player : players) {
			System.out.println("\nPlayer " + player.getId() + " cards in hand:= " + player.getHand().size());
			List<Card> cardsInHand = player.getHand();
			for (int i = 0; i < player.getHand().size(); i++) {
				Card card = cardsInHand.get(i);
				System.out.println(card.getSuit() + " " + card.getCardValue());
			}

		}
	}
}
