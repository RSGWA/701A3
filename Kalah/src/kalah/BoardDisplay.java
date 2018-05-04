package kalah;

import java.util.List;

import com.qualitascorpus.testsupport.IO;

public class BoardDisplay {

	private IO io;
	private Board board;
	
	public BoardDisplay(IO io, Board board) {
		this.board = board;
		
		this.io = io;
		
		printBoard();
	}
	
	public void printBoard() {
		
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	
	List<Integer> playerTwoHouses = board.getPlayerTwoHouses();
	String playerTwo = String.format("| P2 | 6[%2d] | 5[%2d] | 4[%2d] | 3[%2d] | 2[%2d] | 1[%2d] | %2d |", playerTwoHouses.get(5),
			playerTwoHouses.get(4),
			playerTwoHouses.get(3),
			playerTwoHouses.get(2),
			playerTwoHouses.get(1),
			playerTwoHouses.get(0),
			board.getPlayerOneStore());
	String playerTwoString = "| P2 | 6[ " + playerTwoHouses.get(5) + "] | 5[ "
						+ playerTwoHouses.get(4) + "] | 4[ "
						+ playerTwoHouses.get(3) + "] | 3[ "
						+ playerTwoHouses.get(2) + "] | 2[ "
						+ playerTwoHouses.get(1) + "] | 1[ "
						+ playerTwoHouses.get(0) + "] |  "
						+ board.getPlayerOneStore() + " |";
	io.println(playerTwo);
	
	io.println("|    |-------+-------+-------+-------+-------+-------|    |");
	
	List<Integer> playerOneHouses = board.getPlayerOneHouses();
	String playerOne = String.format("| %2d | 1[%2d] | 2[%2d] | 3[%2d] | 4[%2d] | 5[%2d] | 6[%2d] | P1 |", board.getPlayerTwoStore(),
			playerOneHouses.get(0),
			playerOneHouses.get(1),
			playerOneHouses.get(2),
			playerOneHouses.get(3),
			playerOneHouses.get(4),
			playerOneHouses.get(5));
	String playerOneString = "|  " + board.getPlayerTwoStore() + " | 1[ "
					+ playerOneHouses.get(0) + "] | 2[ "
					+ playerOneHouses.get(1) + "] | 3[ " 
					+ playerOneHouses.get(2) + "] | 4[ " 
					+ playerOneHouses.get(3) + "] | 5[ " 
					+ playerOneHouses.get(4) + "] | 6[ " 
					+ playerOneHouses.get(5) + "] | P1 |";
	io.println(playerOne);
	
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	}
}
