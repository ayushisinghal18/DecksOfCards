package deckofcards.elements;

import java.util.ArrayList;
import java.util.List;

import deckofcards.calculator.ScoreCalculator;
import deckofcards.enums.PlayerAction;
import deckofcards.enums.PlayerState;
import deckofcards.participants.BasePlayer;
import deckofcards.participants.Dealer;
import deckofcards.participants.Player;

public class Game {

	private Deck deck;
	private List<Player> players;
	private Dealer dealer;
	private int currentPlayer;
	private ScoreCalculator scoreCalculator;

	public Game() {
		deck = new Deck();
		currentPlayer = 0;
		scoreCalculator = new ScoreCalculator();
		dealer = new Dealer(1);

		players = new ArrayList<>();
	}

	public Dealer getDealer() {
		return dealer;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void startGame() {
		// reset state and cards for dealer and player
		dealer.setState(PlayerState.IN_GAME);
		dealer.setAction(PlayerAction.NONE);
		dealer.getHand().clearHand();

		for (Player player : players) {
			player.setState(PlayerState.IN_GAME);
			player.setAction(PlayerAction.NONE);
			player.getHand().clearHand();
		}

		deck.shuffle(52);

		// deal cards to dealer and player
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				// this.players.get(currentPlayer);
				dealCardToPlayer();
				this.changePlayer();
			}

			dealCardToDealer();
		}

	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void dealCardToPlayer() {
		Player p = this.players.get(currentPlayer);
		Card card = deck.deal();
		p.setCard(card);
		p.setScore(scoreCalculator.getHandValue(p.getHand()));

		if (p.getScore() > 21) {
			p.setState(PlayerState.RESOLVED_BUST);
			p.setAction(PlayerAction.STAND);
		} else if (p.getScore() == 21) {
			p.setAction(PlayerAction.STAND);
		}

		System.out.println("Card dealt to * Player " + p.getId() + " * is: " + card.getCardValue() + " "
				+ card.getSuit() + " [Score: " + p.getScore() + "]");
	}

	public void dealCardToDealer() {
		Card card = deck.deal();
		dealer.setCard(card);
		dealer.setScore(scoreCalculator.getHandValue(dealer.getHand()));

		if (dealer.getScore() > 21) {
			dealer.setState(PlayerState.RESOLVED_BUST);
		}

		System.out.println("Card dealt to * Dealer " + " * is: " + card.getCardValue() + " " + card.getSuit()
				+ " [Score: " + dealer.getScore() + "]");
	}

	private void changePlayer() {
		if (currentPlayer < this.players.size() - 1)
			currentPlayer++;
		else
			currentPlayer = 0;
	}

	public void printHands() {
		System.out.println();
		System.out.println("Dealer's Hand:");
		for (Card card : dealer.getHand().getCards()) {
			System.out.println(card.getCardValue() + " " + card.getSuit());
		}
		System.out.println("Score:= " + scoreCalculator.getHandValue(dealer.getHand()));
		System.out.println();

		for (Player player : players) {
			System.out.println("Player " + player.getId() + " Hand:");
			for (Card card : player.getHand().getCards()) {
				System.out.println(card.getCardValue() + " " + card.getSuit());
			}
			System.out.println("Score:= " + scoreCalculator.getHandValue(player.getHand()));
			System.out.println();
		}
	}

	public void dealerAction() {
		Card card = deck.deal();
		dealer.setCard(card);
		dealer.setScore(scoreCalculator.getHandValue(dealer.getHand()));
		dealer.setAction(PlayerAction.HIT);
		System.out.println("Card dealt to * Dealer " + " [Score: " + dealer.getScore() + "]");

		while (dealer.getScore() < 17) {
			card = deck.deal();
			dealer.setCard(card);
			dealer.setScore(scoreCalculator.getHandValue(dealer.getHand()));
			dealer.setAction(PlayerAction.HIT);
			System.out.println("Card dealt to * Dealer " + " [Score: " + dealer.getScore() + "]");

		}
		dealer.setAction(PlayerAction.STAND);

		if (dealer.getScore() > 21) {
			dealer.setState(PlayerState.RESOLVED_BUST);
		}
	}

}
