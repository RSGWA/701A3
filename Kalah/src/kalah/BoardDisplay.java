package kalah;

import java.util.List;

import com.qualitascorpus.testsupport.IO;

public class BoardDisplay extends GameObserver {

	private IO io;
	private Board board;
	
	public BoardDisplay(IO io, Game game, Board board) {
		this.game = game;
		this.game.attach(this);
		
		this.io = io;
		
		start();
	}
	
	@Override
	public void update() {
		
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	
	List<String> playerTwoHouses = board.getPlayerTwoHouses();
	String playerTwo = "| P2 | 6[ " + playerTwoHouses.get(5) + "] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |";
	io.println(playerTwo);
	
	io.println("|    |-------+-------+-------+-------+-------+-------|    |");
	
	List<String> playerOneHouses = board.getPlayerOneHouses();
	String playerOne = "|  0 | 1[ " + playerOneHouses.get(0) + "] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |";
	io.println(playerOne);
	
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
