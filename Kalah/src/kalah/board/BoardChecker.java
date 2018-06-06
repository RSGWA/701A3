package kalah.board;

import java.util.Collections;
import java.util.List;

import kalah.Game;
import kalah.House;
import kalah.Store;
import kalah.TurnManager;

public class BoardChecker {

	private Board board;
	private Game game;
	
	public BoardChecker(Board board, Game game) {
		this.board = board;
		this.game = game;
	}
	
	public void noMoreMoves(int playerTurn) {
		int counter = 0;
		
		for (House h : board.getPlayers().get(playerTurn).getHouses()) {
			if (h.seedCount() == 0) {
				counter++;
			}
		}
		
		if (counter > 5) {
			game.gameOver();
		}
	}
	
	public boolean emptyHouseSelected(int houseNumber, int playerTurn) {
		int houseIndex = houseNumber - 1;
		
		if (board.getPlayers().get(playerTurn).getHouses().get(houseIndex).seedCount() == 0) {
			return true;
		}
		return false;
	}
	
	public void captureMove(int playerTurn) {
		int houseIndex = board.getHouseLastSown();
		
		// Last seed sown in players store
		if (houseIndex < 0) {
			return;
		}
		
		List<House> playerOneHouses = board.getPlayers().get(0).getHouses();
		List<House> playerTwoHouses = board.getPlayers().get(1).getHouses();
		
		Store playerOneStore = board.getPlayers().get(0).getStore();
		Store playerTwoStore = board.getPlayers().get(1).getStore();

		// Check capture - last seed placed in players own house that was empty and opposite house has at least one seed in it
		if (board.getLastSownInOwnHouse()) {
			if (playerTurn == 0) {
				Collections.reverse(playerTwoHouses);
				
				if (playerOneHouses.get(houseIndex).seedCount() == 1 && playerTwoHouses.get(houseIndex).seedCount() >= 1) {
					int score = playerTwoHouses.get(houseIndex).seedCount() + 1;
					playerOneStore.setSeedCount(playerOneStore.seedCount() + score);
							
					playerOneHouses.get(houseIndex).setSeedCount(0);
					playerTwoHouses.get(houseIndex).setSeedCount(0);
				}	
				Collections.reverse(playerTwoHouses);
			} else {
				Collections.reverse(playerOneHouses);
						
				if (playerTwoHouses.get(houseIndex).seedCount() == 1 && playerOneHouses.get(houseIndex).seedCount() >= 1) {
					int score = playerOneHouses.get(houseIndex).seedCount() + 1;
					playerTwoStore.setSeedCount(playerTwoStore.seedCount() + score);
							
					playerOneHouses.get(houseIndex).setSeedCount(0);
					playerTwoHouses.get(houseIndex).setSeedCount(0);
				}	
				Collections.reverse(playerOneHouses);
			}
		}
	}
	
	public boolean additionalMove() {
		int houseIndex = board.getHouseLastSown();
		if (houseIndex < 0) {
			return true;
		}
		return false;
	}

	public int getPlayerTotalScore(int player) {
		int score = 0;
		for (House h : board.getPlayers().get(player).getHouses()) {
			score += h.seedCount();
		}
		score += board.getPlayers().get(player).getStore().seedCount();
		return score;
	}
	
}
