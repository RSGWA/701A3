package kalah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
	
	private List<Integer> board;
	private Game game;
	private BoardChecker check;
	
	private int houseLastSown;
	
	public Board(Game game) {
		this.game = game;
		board = new ArrayList<>();
		
		// Populate houses with 4 seeds each
		for (int i = 0; i < 14; i++) {
			board.add(4);
		}
		
		// Initialize player store values
		board.set(6, 0);
		board.set(13, 0);
		
		check = new BoardChecker(this, game);
	}
	
	public List<Integer> getPlayerOneHouses() {
		List<Integer> houses = new ArrayList<>(board.subList(0, 6)); 
		return houses;
	}
	
	public List<Integer> getPlayerTwoHouses() {
		List<Integer> houses = new ArrayList<>(board.subList(7, 13)); 
		return houses;
	}
	
	public int getPlayerOneStore() {
		return board.get(6);
	}
	
	public int getPlayerTwoStore() {
		return board.get(13);
	}
	
	public int getSeedCount(int index) {
		return board.get(index);
	}
	
	public int getLastHouseSown() {
		return this.houseLastSown;
	}
	
	// For end game, all seeds on the board are placed in their respective
	// players stores
	public void allSeedsToStore() {
		List<Integer> playerOneHouses = getPlayerOneHouses();
		int score = 0;
		for (int seed : playerOneHouses) {
			if (seed > 0) {
				score = score + seed;
			}
		}
		playerOneHouses.add(getPlayerOneStore() + score);
		score = 0;
		List<Integer> playerTwoHouses = getPlayerTwoHouses();
		for (int seed : playerTwoHouses) {
			if (seed > 0) {
				score = score + seed;
			}
		}
		playerTwoHouses.add(getPlayerTwoStore() + score);
		
		List<Integer> newBoard = new ArrayList<>(playerOneHouses);
		newBoard.addAll(playerTwoHouses);
						
		board = newBoard;
	}
	
	public void capture(int houseIndex) {
		List<Integer> playerOneHouses = getPlayerOneHouses();
		List<Integer> playerTwoHouses = getPlayerTwoHouses();
		if (game.getPlayerTurn() == 1) {
			
			Collections.reverse(playerTwoHouses);
			int score = playerTwoHouses.get(houseIndex) + 1;
			playerOneHouses.add(getPlayerOneStore() + score);
					
			playerOneHouses.set(houseIndex, 0);
			playerTwoHouses.set(houseIndex, 0);
			Collections.reverse(playerTwoHouses);
			playerTwoHouses.add(getPlayerTwoStore());
		} else {
			houseIndex = houseIndex - 7;
			Collections.reverse(playerOneHouses);
			int score = playerOneHouses.get(houseIndex) + 1;
							
			playerTwoHouses.add(getPlayerTwoStore() + score);
							
			playerTwoHouses.set(houseIndex, 0);
			playerOneHouses.set(houseIndex, 0);
			Collections.reverse(playerOneHouses);
			playerOneHouses.add(getPlayerOneStore());
		}
		List<Integer> newBoard = new ArrayList<>(playerOneHouses);
		newBoard.addAll(playerTwoHouses);
						
		board = newBoard;
	}
	
	public void updateBoard(int houseNumber) {
		
		int houseIndex = houseNumber - 1;
		
		// Adjust house index according to whose turn it is
		if (game.getPlayerTurn() == 2) {
			houseIndex = houseIndex + 7;
		}
		
		// Seed count of chosen house
		int seeds = board.get(houseIndex);
		int seedsUsed = 0;
		
		board.set(houseIndex, 0); // Pick up all seeds in chosen house
		
		houseIndex++; // Start sowing at house after chosen house
		
		while (seedsUsed < seeds) {
			
			if (houseIndex > board.size() - 1) {
				houseIndex = 0;
			}
			
			if (((game.getPlayerTurn() == 1) && (houseIndex != 13)) || ((game.getPlayerTurn() == 2) && (houseIndex != 6))) {
				board.set(houseIndex, board.get(houseIndex) + 1);
				seedsUsed++;
			}
			houseIndex++;
		}
		
		houseLastSown = houseIndex - 1;
		
		if (check.captureMove()) {
			capture(houseLastSown);
		}
	}

}
