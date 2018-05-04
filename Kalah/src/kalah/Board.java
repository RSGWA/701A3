package kalah;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Integer> board;
	
	public Board() {
		board = new ArrayList<>();
		
		// Populate houses with 4 seeds each
		for (int i = 0; i < 14; i++) {
			board.add(4);
		}
		
		// Initialize player store values
		board.set(6, 0);
		board.set(13, 0);
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

	public void updateBoard(int houseNumber, int playerTurn) {
		
		int houseIndex = houseNumber - 1;
		
		if (playerTurn == 2) {
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
			
			if (((playerTurn == 1) && (houseIndex != 13)) || ((playerTurn == 2) && (houseIndex != 6))) {
				board.set(houseIndex, board.get(houseIndex) + 1);
				seedsUsed++;
			}
			houseIndex++;
		}
	}
}
