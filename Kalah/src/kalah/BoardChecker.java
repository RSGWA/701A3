package kalah;

import java.util.Collections;
import java.util.List;

public class BoardChecker {

	private Board board;
	private Game game;
	
	public BoardChecker(Board board, Game game) {
		this.board = board;
		this.game = game;
	}
	
	public void noMoreMoves() {
		int counter = 0;
		if (game.getPlayerTurn() == 1) {
			for (int seed : board.getPlayerOneHouses()) {
				if (seed == 0) {
					counter++;
				}
			}
		} else {
			for (int seed : board.getPlayerTwoHouses()) {
				if (seed == 0) {
					counter++;
				}
			}
		}
		if (counter > 5) {
			game.gameOver();
		}
	}
	
	public boolean emptyHouseSelected(int houseNumber) {
		int houseIndex;
		if (game.getPlayerTurn() == 1) {
			houseIndex = houseNumber - 1;
		} else {
			houseIndex = houseNumber + 6;
		}

		if (board.getSeedCount(houseIndex) == 0) {
			return true;
		}
		return false;
	}
	
	public boolean captureMove() {
		int houseIndex = board.getLastHouseSown();
		List<Integer> playerOneHouses = board.getPlayerOneHouses();
		List<Integer> playerTwoHouses = board.getPlayerTwoHouses();
		// Check capture - last seed placed in players own house that was empty and opposite house is empty
		if (game.getPlayerTurn() == 1) {
			if (0 <= houseIndex && houseIndex <= 5) {
				Collections.reverse(playerTwoHouses);
				
				if (playerOneHouses.get(houseIndex) == 1 && playerTwoHouses.get(houseIndex) >= 1) {
					return true;
				}	
			}
		} else {
			if (7 <= houseIndex && houseIndex <= 12) {
				houseIndex = houseIndex - 7;
				Collections.reverse(playerOneHouses);
						
				if (playerTwoHouses.get(houseIndex) == 1 && playerOneHouses.get(houseIndex) >= 1) {
					return true;
				}	
			}
		}
		return false;
	}
	
	public boolean additionalMove() {
		int houseIndex = board.getLastHouseSown();
		if (((game.getPlayerTurn() == 1) && (houseIndex == 6)) || ((game.getPlayerTurn() == 2) && (houseIndex == 13))) {
			return true;
		}
		
		return false;
	}
	
}
