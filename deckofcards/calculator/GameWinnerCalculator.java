package deckofcards.calculator;

import java.util.List;

import deckofcards.enums.PlayerState;
import deckofcards.participants.Dealer;
import deckofcards.participants.Player;

public class GameWinnerCalculator {

	public void calculateScore(Dealer dealer, List<Player> players) {
		if (dealer.getState().equals(PlayerState.RESOLVED_BUST)) { // dealer busted

			for (Player p : players) {
				if (!(p.getState().equals(PlayerState.RESOLVED_BUST))) {
					double winningScore = calculate(p.getBet());
					p.updateBalance(p.getBet(), true);
					System.out.println("Player " + p.getId() + " wins with bet: " + winningScore);
					System.out.println("Total balance is:= " + p.getBalance());
				} else {
					p.updateBalance(p.getBet(), false);
					System.out.println("Player " + p.getId() + " loses with bet: " + p.getBet());
					System.out.println("Total balance is:= " + p.getBalance());
				}
			}
		} else { // player wins

			for (Player p : players) {
				if ((p.getState().equals(PlayerState.RESOLVED_BUST))) {
					System.out.println("Player " + p.getId() + " loses with bet: " + p.getBet());
				} else {
					if (p.getScore() == dealer.getScore()) { // tie
						// the bet is returned
						System.out.println("Player " + p.getId() + " wins with bet: " + p.getBet());
					} else if (p.getScore() > dealer.getScore()) { // player wins
						// "blackjack" is paid 3:2. any other winning hand is paid 1:1
						double winningScore = calculate(p.getBet());
						p.updateBalance(winningScore, true);
						System.out.println("Player " + p.getId() + " wins with bet: " + winningScore);
						System.out.println("Total balance is:= " + p.getBalance());
					} else if (p.getScore() < dealer.getScore()) { // dealer wins
						p.updateBalance(p.getBet(), false);
						System.out.println("Player " + p.getId() + " loses with bet: " + p.getBet());
						System.out.println("Total balance is:= " + p.getBalance());
					}
				}
			}
		}
	}

	private double calculate(double score) {
		if (score == 21) { // blackjack
			score += score / 2;
		}
		return score;
	}
}
