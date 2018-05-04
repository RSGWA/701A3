package kalah;

import java.util.List;

import com.qualitascorpus.testsupport.IO;

public class Board extends GameObserver {

	private IO io;
	
	public Board(IO io, Game game) {
		this.game = game;
		this.game.attach(this);
		this.io = io;
		
		start();
	}
	
	@Override
	public void update() {
		
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	
	List<Integer> playerTwoHouses = game.getPlayerTwoHouses();
	String playerTwo = "| P2 | 6[ " + playerTwoHouses.get(5) + "] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |";
	io.println(playerTwo);
	
	io.println("|    |-------+-------+-------+-------+-------+-------|    |");
	
	List<Integer> playerOneHouses = game.getPlayerOneHouses();
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
