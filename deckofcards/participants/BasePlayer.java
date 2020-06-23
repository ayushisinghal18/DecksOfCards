package deckofcards.participants;

import deckofcards.elements.Card;
import deckofcards.elements.Hand;
import deckofcards.enums.PlayerAction;
import deckofcards.enums.PlayerState;

public class BasePlayer {
	private int id;
	private int wins;
	private Hand hand;
	//private double balance;
	private Integer score;
	private PlayerState state;
	private PlayerAction action;	

	public BasePlayer(int id) {
		this.id = id;
		hand = new Hand();
	}

	public int getId() {
		return id;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public Hand getHand() {
		return hand;
	}

	public void setCard(Card card) {
		this.hand.addCardInHand(card);
	}

	/*public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance += balance;
	}*/

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public PlayerState getState() {
		return state;
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public PlayerAction getAction() {
		return action;
	}

	public void setAction(PlayerAction action) {
		this.action = action;
	}

}
