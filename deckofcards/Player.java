package deckofcards;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private int wins;
	private List<Card> hand;

	public Player(int id) {
		this.id = id;
		hand = new ArrayList<>();
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

	public List<Card> getHand() {
		return hand;
	}

}
