package kalah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

	// Index is the number of the house and the value is the number
	// of seeds stored in that house.
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
	public int sow(int houseNumber) {
		
		int seeds = houses.get(houseNumber - 1);
		
		// If house number 6 is chosen, sow seed into players store
		if (houseNumber == 6) {
			store++;
			if (seeds > 1) {
				return seeds - 1;
			} else {
				return 0;
			}
		} else {
			
			for (int i = houseNumber; i < houseNumber + seeds - 1; i ++) {
				if (i == 6) {
					store++;
					// TODO: Fix
					// return seeds - 1; 
				} else {
					houses.set(i, houses.get(i) + 1);
				}
			}
		}
		
		return 0;
	}
}
