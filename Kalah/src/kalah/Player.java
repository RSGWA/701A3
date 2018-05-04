package kalah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

	private List<Integer> houses;
	private int store;
	
	public Player() {
		houses = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			houses.add(4);
		}
		store = 0;
	}
	
	public List<Integer> getHouses() {
		return Collections.unmodifiableList(houses);
	}
	
	public int storeCount() {
		return this.store;
	}
	
	// Sows seeds into houses and respective players store. 
	// Returns true if the player must sow seeds into the opposing players houses
	// Returns false if the player has sown its last seed within its own houses or its store
	public boolean sow(int houseNumber) {
		
		int seeds = houses.get(houseNumber - 1);
		
		// If house number 6 is chosen, sow seed into players store
		if (houseNumber == 6) {
			store++;
			if (seeds > 1) {
				return true;
			} else {
				return false;
			}
		} else {
			
			for (int i = houseNumber; i < houseNumber + seeds; i ++) {
				if (i == 6) {
					store++;
				} else if (i > 6) {
					return true;
				} else {
					houses.set(i, houses.get(i) + 1);
				}
			}
		}
		
		return false;
	}
}
