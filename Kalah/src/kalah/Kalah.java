package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}
	public void play(IO io) {

		Game game = new Game();
		Board board = new Board(game);
		BoardDisplay display = new BoardDisplay(io, board);
		
		while (!game.isGameOver()) {
			int houseNumber = io.readInteger("Player P" + game.getPlayerTurn() + "'s turn - Specify house number or 'q' to quit: ", 1, 6, -1, "q");
			// Quit the game
			if (houseNumber == -1) {
				break;
			}
			
			if (board.checkEmptyHouse(houseNumber)) {
				io.println("House is empty. Move again.");
			} else {
				board.updateBoard(houseNumber);
				game.nextPlayerTurn();
			}
			display.printBoard();
		}
		
	}
}
