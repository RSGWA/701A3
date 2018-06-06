package kalah;

public abstract class Pit {

	protected int seeds;
	
	public void increment() {
		this.seeds++;
	}
	
	public void setSeedCount(int seeds) {
		this.seeds = seeds;
	}
	
	public int seedCount() {
		return this.seeds;
	}
}
