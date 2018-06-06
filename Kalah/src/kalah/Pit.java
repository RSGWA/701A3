package kalah;

public class Pit {

	protected int seeds;
	
	public void increment() {
		this.seeds++;
	}
	
	public void setSeedCount(int seeds) {
		if (seeds < 0) {
			this.seeds = 0;
		} else {
			this.seeds = seeds;
		}
	}
	
	public int seedCount() {
		return this.seeds;
	}
}
