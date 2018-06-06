package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;

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
		TurnManager tm = new TurnManager();
		Board board = new Board();
		BoardChecker check = new BoardChecker(board, game);
		BoardDisplay display = new BoardDisplay(io, board.getPlayers());
		
		boolean quit = false;
		
		while (!game.isGameOver()) {
			int playerTurnDisplay = tm.getPlayerTurn() + 1;
			int houseNumber = io.readInteger("Player P" + playerTurnDisplay + "'s turn - Specify house number or 'q' to quit: ", 1, 6, -1, "q");
			// Quit the game
			if (houseNumber == -1) {
				quit = true;
				break;
			}
			
			if (check.emptyHouseSelected(houseNumber, tm.getPlayerTurn())) {
				io.println("House is empty. Move again.");
			} else {
				board.move(houseNumber, tm.getPlayerTurn());
				check.captureMove(tm.getPlayerTurn());
				if (!check.additionalMove()) {
					tm.nextPlayerTurn();
				}
			}
			
			display.printBoard();
			
			check.noMoreMoves(tm.getPlayerTurn());
		}
		
		display.printGameOver();
		
		if (!quit) {
			// Display total scores for each player to determine the winner
			display.printScores(check.getPlayerTotalScore(0), check.getPlayerTotalScore(1));
		}
		
	}
}
