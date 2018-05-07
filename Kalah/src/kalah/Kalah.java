package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;

import kalah.board.Board;
import kalah.board.BoardChecker;
import kalah.board.BoardDisplay;

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
		BoardChecker check = new BoardChecker(board, game);
		BoardDisplay display = new BoardDisplay(io, board);
		
		boolean quit = false;
		
		while (!game.isGameOver()) {
			int houseNumber = io.readInteger("Player P" + game.getPlayerTurn() + "'s turn - Specify house number or 'q' to quit: ", 1, 6, -1, "q");
			// Quit the game
			if (houseNumber == -1) {
				quit = true;
				break;
			}
			
			if (check.emptyHouseSelected(houseNumber)) {
				io.println("House is empty. Move again.");
			} else {
				board.updateBoard(houseNumber);
				if (!check.additionalMove()) {
					game.nextPlayerTurn();
				}
			}
			display.printBoard();
			check.noMoreMoves();
		}
		
		display.printGameOver();
		
		if (!quit) {
			// Place all seeds in respective players store to decide winner
			board.allSeedsToStore();
			display.printScores();
		}
		
	}
}
