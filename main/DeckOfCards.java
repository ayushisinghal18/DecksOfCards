package main;

import java.util.Scanner;

import deckofcards.calculator.GameWinnerCalculator;
import deckofcards.elements.Game;
import deckofcards.enums.PlayerAction;
import deckofcards.enums.PlayerState;
import deckofcards.participants.Player;

public class DeckOfCards {

	public static void main(String[] args) {
		Game game = new Game();
		GameWinnerCalculator gameWinnerCalculator = new GameWinnerCalculator();
		Scanner scan = new Scanner(System.in);

		Player p1 = new Player(101, 1000);
		Player p2 = new Player(102, 500);
		game.addPlayer(p1);
		// game.addPlayer(p2);
		boolean continuePlaying=true;
		
		try {
			while (continuePlaying) {
				System.out.println("Current balance for Player " + p1.getId() + " is := " + p1.getBalance());
				System.out.println("Enter your bet:=");
				double bet = scan.nextDouble();
				while (bet > p1.getBalance()) {
					System.out.println("Bet should be less than your balance. Please re-enter.");
					bet = scan.nextDouble();
				}
				p1.setBet(bet);

				game.startGame();
				game.printHands();

				while (!p1.getAction().equals(PlayerAction.STAND)) {

					System.out.println("*** Choose your action ***");
					System.out.println("***    [hit, stand]    ***");
					
					boolean inputGiven = false;
					while (!inputGiven) {
						try {
							String action = PlayerAction.NONE.toString();
							while (!PlayerAction.valueOf(action.toUpperCase()).equals(PlayerAction.HIT)
									&& !PlayerAction.valueOf(action.toUpperCase()).equals(PlayerAction.STAND)) {
								action = scan.next();
								p1.setAction(PlayerAction.valueOf(action.toUpperCase()));
								inputGiven = true;
							}
						} catch (IllegalArgumentException e) {
							System.out.println("Please retry");
							inputGiven = false;
						}
					}

					if (p1.getAction().equals(PlayerAction.HIT) && !p1.getState().equals(PlayerState.RESOLVED_BUST)) {
						game.dealCardToPlayer();
					}
				}

				while (!game.getDealer().getAction().equals(PlayerAction.STAND)
						&& !game.getDealer().getState().equals(PlayerState.RESOLVED_BUST)) {
					game.dealerAction();
				}

				gameWinnerCalculator.calculateScore(game.getDealer(), game.getPlayers());
				
				continuePlaying=false;
				for (Player player : game.getPlayers()) {
					if(player.getBalance()>0) {
						continuePlaying=true;
					}
				}
			}
			System.out.println("Thanks for playing!!");
			
		} catch (NullPointerException | IllegalArgumentException ex) {
			System.err.println("Error Occurred := " + ex);
			game.printHands();
		}
	}
}
