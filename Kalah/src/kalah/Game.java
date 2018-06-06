package kalah;

public class Game {

	private boolean gameOver;
	
	public Game() {
		this.gameOver = false;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	public void gameOver() {
		gameOver = true;
	}
	
}
