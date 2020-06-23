package deckofcards.participants;

public class Player extends BasePlayer {

	private double bet;
	private double balance;

	public Player(int id, double balance) {
		super(id);
		this.balance = balance;
	}

	public double getBet() {
		return bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}

	public double getBalance() {
		return balance;
	}

	public void updateBalance(double balance, boolean win) {
		if (win)
			this.balance += balance;
		else
			this.balance -= balance;
	}

}
