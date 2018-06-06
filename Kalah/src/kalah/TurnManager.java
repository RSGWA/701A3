package kalah;

public class TurnManager {
	
	private int playerTurn;
	
	// 0 - Player 1
	// 1 - Player 2
	public TurnManager() {
		this.playerTurn = 0;
	}
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	
	public void nextPlayerTurn() {
		if (playerTurn == 0) {
			playerTurn = 1;
		} else {
			playerTurn = 0;
		}
	}
}
