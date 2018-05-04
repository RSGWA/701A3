package kalah;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Integer> playerOneHouses;
	private List<Integer> playerTwoHouses;
	
	private List<Integer> board;
	
	private int playerOneStore;
	private int playerTwoStore;
	
	private Game game;
	
	public Board(Game game) {
		this.game = game;
		
		playerOneHouses = new ArrayList<>();
		playerTwoHouses = new ArrayList<>();
		
		board = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			board.add(4);
		}
	}
	
	public List<String> getPlayerOneHouses() {
		List<String> houses = new ArrayList<String>(playerOneHouses.size()); 
		for (Integer myInt : playerOneHouses) { 
			houses.add(String.valueOf(myInt)); 
		}
		return houses;
	}
	
	public List<String> getPlayerTwoHouses() {
		List<String> houses = new ArrayList<String>(playerTwoHouses.size()); 
		for (Integer myInt : playerTwoHouses) { 
			houses.add(String.valueOf(myInt)); 
		}
		return houses;
	}

	public void updateBoard(int houseNumber) {
		
		int houseIndex = houseNumber - 1;
		
		if (game.getPlayerTurn() == 2) {
			houseIndex = houseIndex + 7;
		}
		
		// Seed count of chosen house
		int seeds = board.get(houseIndex);
		int seedsUsed = 0;
		
		houseIndex++; // Start sowing at house after chosen house
		
		while (seedsUsed < seeds) {
			
			if (((game.getPlayerTurn() == 1) && (houseIndex != 13)) || ((game.getPlayerTurn() == 2) && (houseIndex != 6))) {
				board.set(houseIndex, board.get(houseIndex) + 1);
				seedsUsed++;
			}
			if (houseIndex > board.size()) {
				houseIndex = 0;
			}
			houseIndex++;
		}
	}
}
