package kalah;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<House> houses;
	private Store store;
	
	public final static int HOUSES_PER_PLAYER = 6;
	public final static int SEEDS_PER_HOUSE = 4;
	
	public Player() {
		this.houses = new ArrayList<>();
		this.store = new Store();
		
		for (int i = 0; i < HOUSES_PER_PLAYER; i++) {
			this.houses.add(new House(SEEDS_PER_HOUSE));
		}
		
	}
	
	public List<House> getHouses() {
		return houses;
	}
	
	public Store getStore() {
		return store;
	}
}
