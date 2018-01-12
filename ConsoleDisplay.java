/*
 * A type of display that outputs the game onto a text screen.
 */
public class ConsoleDisplay implements Display {
	/*
	 * Constructor, does nothing as there is no need for ConsoleDisplay to hold any data.
	 */
	public ConsoleDisplay() { }
	/*
	 * Prints the current state of the board and other data.
	 * @paran b - the board to be printed.
	 * @paran turn - the player whose turn it is.
	 * @paran moves - the moves available to the player.
	 */
	public void Print(Board b, int turn, int[] moves) {
		System.out.println("Current board:");
		System.out.println();
		PrintBoard(b);
		PrintTurn(turn);
		PrintMoves(moves);
	}
	/**
	 * Prints the current board.
	 * @param b - the board.
	 */
	public void PrintBoard(Board b) {
		for (int i = 1; i < b.getWidth() + 1; i++) {
			System.out.print(" | " + i);
		}
		System.out.println(" |");
		PrintDashLine(b);
		for (int j = 1; j <= b.getHeight(); j++) {
			System.out.print(j + "| ");
			for (int i = 1; i <= b.getWidth(); i++) {
				switch (b.get(i, j)) {
					case 0:
						System.out.print(" ");
						break;
					case 1:
						System.out.print("O");
						break;
					case 2:
						System.out.print("X");
						break;
					default:
						System.out.print("E");
						break;
				}
				System.out.print(" | ");
			}
			System.out.println();
			PrintDashLine(b);
		}
	}
	/*
	 * Asks the player for a move.
	 */
	public void AskForMove() {
		System.out.println("Please enter your move row,col: ");
	}
	/*
	 * Tells the player that the move they chose is invalid.
	 */
	public void InvalidMove() {
		System.out.println("Invalid move, please choose another move");
	}
	/*
	 * Tells the player that the input format was incorrect.
	 */
	public void InvalidFormat() {
		System.out.print("Invalid input format, please input two integers separated by");
		System.out.println(" a single character, preferably a comma.");
	}
	/*
	 * Declares who the winner of the game is.
	 * @param state - the winner, number of O and number of X.
	 */
	public void DeclareWinner(int[] state) {
		System.out.println("0: " + state[1]);
		System.out.println("X: " + state[2]);
		switch (state[0]) {
			case 0:
				System.out.print("Game over, an early victory for player: ");
				if (state[2] > state[1]) {
					System.out.println("X!");
				} else {
					System.out.println("O!");
				}
				break;
			case 1:
				System.out.println("Game over, player O has won!");
				break;
			case 2:
				System.out.println("Game over, player X has won!");
				break;
			case 3:
				System.out.println("Game over, it's a tie.");
				break;
			default:
				System.out.print("Game over, an error has occurred and");
				System.out.println(" a winner cannot be determined.");
			break;
		}
	}
	/**
	 * Prints a blank line of dashes.
	 * @param b - the board.
	 */
	private void PrintDashLine(Board b) {
		for (int i = 0; i < (b.getWidth() * 2) + 1; i++) {
			System.out.print("--");
		}
		System.out.println();
	}
	/*
	 * Prints whose turn it is.
	 * @param turn - the turn indicator.
	 */
	private void PrintTurn(int turn) {
		if (turn == 1) {
			System.out.print("O");
		} else {
			System.out.print("X");
		}
		System.out.println(": It's your move.");
		
	}
	/**
	 * Prints a list of possible moves the player can make.
	 * @param moves - a list of cords, assumed to be 1 + even.
	 */
	private void PrintMoves(int[] moves) {
		if (moves[0] == 0) {
			//no possible moves, switch to other player
			System.out.print("No possible moves. Play passes back to");
			System.out.println(" the other player. Press any key to continue.");
			//cin.ignore(); TODO press any key to continue
		} else {
			System.out.print("Your possible moves: ");
			for (int i = 1; i < moves[0] ; i+= 2) {
				System.out.print("(" + moves[i] + "," + moves[i + 1] + ") ");
			}
			System.out.println();
		}
	}
}