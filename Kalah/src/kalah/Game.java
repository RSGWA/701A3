package kalah;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<GameObserver> observers = new ArrayList<GameObserver>();
	
	private int playerTurn;
	private boolean gameOver;
	
	private Player playerOne;
	private Player playerTwo;
	
	public Game() {
		this.playerOne = new Player();
		this.playerTwo = new Player();
		this.playerTurn = 1;
		this.gameOver = false;
	}
	
	public void updateGameState(int houseNumber) {
		
		if (playerTurn == 1) {
			int leftOverSeeds = playerOne.sow(houseNumber);
			if (leftOverSeeds > 1) {
				System.out.println("NOW SOWING IN PLAYER TWOS HOUSES");
			}
		} else {
			
		}
		nextPlayerTurn();
		notifyAllObservers();
	}
	
	public List<Integer> getPlayerOneHouses() {
		return playerOne.getHouses();
	}
	
	public List<Integer> getPlayerTwoHouses() {
		return playerTwo.getHouses();
	}
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	private void nextPlayerTurn() {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}
	}
	
	public void attach(GameObserver observer) {
		observers.add(observer);		
	}
	
	// Call to update board
	public void notifyAllObservers() {
		for (GameObserver observer : observers) {
			observer.update();
		}
	}
}
