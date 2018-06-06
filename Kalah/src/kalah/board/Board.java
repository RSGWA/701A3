package kalah.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kalah.House;
import kalah.Player;

public class Board {
	
	private List<Player> players;
	private int houseLastSown = 0;
	private boolean lastSownInOwnHouse = false;
	
	public Board() {
		Player playerOne = new Player();
		Player playerTwo = new Player();
		players = new ArrayList<>();
		players.add(playerOne);
		players.add(playerTwo);
	}
	
	public void move(int houseNumber, int playerTurn) {
		int houseIndex = houseNumber - 1;
		
		List<House> housesBeingSown = new ArrayList<>();
	
		int seeds = 0;
		housesBeingSown = players.get(playerTurn).getHouses();
		seeds = housesBeingSown.get(houseIndex).seedCount();
		
		// Pick up all seeds in chosen house
		housesBeingSown.get(houseIndex).setSeedCount(0);
		// Start sowing at house after chosen house
		houseIndex++;
		
		int seedsUsed = 0;
		int currentPlayersHousesBeingSown = playerTurn;
		
		while (seedsUsed < seeds) {
			
			if (houseIndex > Player.HOUSES_PER_PLAYER - 1) {
				if (currentPlayersHousesBeingSown == playerTurn) {
					players.get(playerTurn).getStore().increment();
					seedsUsed++;
				}
				
				if (currentPlayersHousesBeingSown == 0) {
					currentPlayersHousesBeingSown = 1;
				} else {
					currentPlayersHousesBeingSown = 0;
				}
				
				houseIndex = 0;
				housesBeingSown = players.get(currentPlayersHousesBeingSown).getHouses();
				continue;
			}
			
			housesBeingSown.get(houseIndex).increment();
			seedsUsed++;
			houseIndex++;
		}
		
		houseLastSown = houseIndex - 1;
		
		if (currentPlayersHousesBeingSown == playerTurn) {
			lastSownInOwnHouse = true;
		} else {
			lastSownInOwnHouse = false;
		}
		
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public int getHouseLastSown() {
		return this.houseLastSown;
	}
	
	public boolean getLastSownInOwnHouse() {
		return this.lastSownInOwnHouse;
	}
}
