package kalah.board;

import java.util.List;

import com.qualitascorpus.testsupport.IO;

import kalah.House;
import kalah.Player;

public class BoardDisplay {

	private IO io;
	private Player playerOne;
	private Player playerTwo;
	
	public BoardDisplay(IO io, List<Player> players) {
		this.io = io;
		this.playerOne = players.get(0);
		this.playerTwo = players.get(1);
		
		printBoard();
	}
	
	public void printScores(int playerOneScore, int playerTwoScore) {
		
		io.println("\tplayer 1:" + playerOneScore);
		io.println("\tplayer 2:" + playerTwoScore);
		
		if (playerOneScore > playerTwoScore) {
			io.println("Player 1 wins!");
		} else if (playerOneScore == playerTwoScore) {
			io.println("A tie!");
		} else {
			io.println("Player 2 wins!");
		}
	}
	
	public void printGameOver() {
		io.println("Game over");
		printBoard();
	}
	
	public void printBoard() {
		
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	
	List<House> playerTwoHouses = playerTwo.getHouses();
	String playerTwoString = String.format("| P2 | 6[%2d] | 5[%2d] | 4[%2d] | 3[%2d] | 2[%2d] | 1[%2d] | %2d |", playerTwoHouses.get(5).seedCount(),
			playerTwoHouses.get(4).seedCount(),
			playerTwoHouses.get(3).seedCount(),
			playerTwoHouses.get(2).seedCount(),
			playerTwoHouses.get(1).seedCount(),
			playerTwoHouses.get(0).seedCount(),
			playerOne.getStore().seedCount());
	io.println(playerTwoString);
	
	io.println("|    |-------+-------+-------+-------+-------+-------|    |");
	
	List<House> playerOneHouses = playerOne.getHouses();
	String playerOneString = String.format("| %2d | 1[%2d] | 2[%2d] | 3[%2d] | 4[%2d] | 5[%2d] | 6[%2d] | P1 |", playerTwo.getStore().seedCount(),
			playerOneHouses.get(0).seedCount(),
			playerOneHouses.get(1).seedCount(),
			playerOneHouses.get(2).seedCount(),
			playerOneHouses.get(3).seedCount(),
			playerOneHouses.get(4).seedCount(),
			playerOneHouses.get(5).seedCount());
	io.println(playerOneString);
	
	io.println("+----+-------+-------+-------+-------+-------+-------+----+");
	}
}
