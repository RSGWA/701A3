package kalah;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<GameObserver> observers = new ArrayList<GameObserver>();
	
	private int playerTurn;
	private boolean gameOver;
	
	public Game() {
		this.playerTurn = 1;
		this.gameOver = false;
	}
	
	public void updateGameState() {	
		nextPlayerTurn();
		notifyAllObservers();
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
