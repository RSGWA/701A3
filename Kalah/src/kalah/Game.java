package kalah;

public class Game {

	private int playerTurn;
	private boolean gameOver;
	private boolean playerContinues;
	
	public Game() {
		this.playerTurn = 1;
		this.gameOver = false;
		this.playerContinues = false;
	}
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	public void gameOver() {
		gameOver = true;
	}
	
	public void nextPlayerTurn() {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}
	}
	
}
