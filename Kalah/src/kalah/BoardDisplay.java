package kalah;

import java.util.List;

import com.qualitascorpus.testsupport.IO;

public class BoardDisplay extends GameObserver {

	private IO io;
	private Board board;
	
	public BoardDisplay(IO io, Game game, Board board) {
		this.game = game;
		this.game.attach(this);
		
		this.board = board;
		
		this.io = io;
		
		start();
	}
	
	@Override
	public void update() {
		
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	
	List<Integer> playerTwoHouses = board.getPlayerTwoHouses();
	String playerTwoString = "| P2 | 6[ " + playerTwoHouses.get(5) + "] | 5[ "
						+ playerTwoHouses.get(4) + "] | 4[ "
						+ playerTwoHouses.get(3) + "] | 3[ "
						+ playerTwoHouses.get(2) + "] | 2[ "
						+ playerTwoHouses.get(1) + "] | 1[ "
						+ playerTwoHouses.get(0) + "] |  "
						+ board.getPlayerOneStore() + " |";
	io.println(playerTwoString);
	
	io.println("|    |-------+-------+-------+-------+-------+-------|    |");
	
	List<Integer> playerOneHouses = board.getPlayerOneHouses();
	String playerOneString = "|  " + board.getPlayerTwoStore() + " | 1[ "
					+ playerOneHouses.get(0) + "] | 2[ "
					+ playerOneHouses.get(1) + "] | 3[ " 
					+ playerOneHouses.get(2) + "] | 4[ " 
					+ playerOneHouses.get(3) + "] | 5[ " 
					+ playerOneHouses.get(4) + "] | 6[ " 
					+ playerOneHouses.get(5) + "] | P1 |";
	io.println(playerOneString);
	
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	}
	
	private void start() {
		io.println("+----+-------+-------+-------+-------+-------+-------+----+");
		io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
		io.println("|    |-------+-------+-------+-------+-------+-------|    |");
		io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
		io.println("+----+-------+-------+-------+-------+-------+-------+----+");	
	}
	
}
