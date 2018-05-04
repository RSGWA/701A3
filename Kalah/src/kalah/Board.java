package kalah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
	
	private List<Integer> board;
	
	private Game game;
	
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

	public boolean checkEmptyHouse(int houseNumber) {
		int houseIndex;
		if (game.getPlayerTurn() == 1) {
			houseIndex = houseNumber - 1;
		} else {
			houseIndex = houseNumber + 6;
		}

		if (board.get(houseIndex) == 0) {
			return true;
		}
		return false;
	}

	private void checkCantMove() {
		int counter = 0;
		if (game.getPlayerTurn() == 1) {
			for (int seed : getPlayerOneHouses()) {
				if (seed == 0) {
					counter++;
				}
			}
		} else {
			for (int seed : getPlayerTwoHouses()) {
				if (seed == 0) {
					counter++;
				}
			}
		}
		if (counter >= 5) {
			game.gameOver();
		}
	}
	public void updateBoard(int houseNumber) {
		
		checkCantMove();
		
		int houseIndex = houseNumber - 1;
		
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
		
		// Make house index represent the house where the last seed was sown
		houseIndex--;
		
		// Last seed is sown in players store so they continue
		if (((game.getPlayerTurn() == 1) && (houseIndex == 6)) || ((game.getPlayerTurn() == 2) && (houseIndex == 13))) {
			game.nextPlayerTurn();
		}
		
		// Check capture - last seed placed in players own house that was empty and opposite house is empty
		checkCapture(houseIndex);
	}
	
	private void checkCapture(int houseIndex) {
		// Check capture - last seed placed in players own house that was empty and opposite house is empty
				if (game.getPlayerTurn() == 1) {
					if (0 <= houseIndex && houseIndex <= 5) {
						List<Integer> playerOneHouses = getPlayerOneHouses();
						List<Integer> playerTwoHouses = getPlayerTwoHouses();
						Collections.reverse(playerTwoHouses);
						
						if (playerOneHouses.get(houseIndex) == 1 && playerTwoHouses.get(houseIndex) >= 1) {
							int score = playerTwoHouses.get(houseIndex) + 1;
							playerOneHouses.add(getPlayerOneStore() + score);
							
							playerOneHouses.set(houseIndex, 0);
							playerTwoHouses.set(houseIndex, 0);
							Collections.reverse(playerTwoHouses);
							playerTwoHouses.add(getPlayerTwoStore());
							
							List<Integer> newBoard = new ArrayList<>(playerOneHouses);
							newBoard.addAll(playerTwoHouses);
							
							board = newBoard;
						}	
					}
				} else {
					if (7 <= houseIndex && houseIndex <= 12) {
						houseIndex = houseIndex - 7;
						List<Integer> playerOneHouses = getPlayerOneHouses();
						List<Integer> playerTwoHouses = getPlayerTwoHouses();
						Collections.reverse(playerOneHouses);
						
						if (playerTwoHouses.get(houseIndex) == 1 && playerOneHouses.get(houseIndex) >= 1) {
							int score = playerOneHouses.get(houseIndex) + 1;
							
							playerTwoHouses.add(getPlayerTwoStore() + score);
							
							playerTwoHouses.set(houseIndex, 0);
							playerOneHouses.set(houseIndex, 0);
							Collections.reverse(playerOneHouses);
							playerOneHouses.add(getPlayerOneStore());
							
							List<Integer> newBoard = new ArrayList<>(playerOneHouses);
							newBoard.addAll(playerTwoHouses);
							
							board = newBoard;
						}	
					}
				}
	}
}
