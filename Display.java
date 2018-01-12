package application;
/*
 * A display for the game.
 */
public interface Display {
	/*
	 * Prints the current state of the board and other data.
	 * @paran b - the board to be printed.
	 * @paran turn - the player whose turn it is.
	 * @paran moves - the moves available to the player.
	 */
	public void Print(Board b, int turn, int[] moves);
	/**
	 * Prints the current board.
	 * @param b - the board.
	 */
	public void PrintBoard(Board b);
	/*
	 * Tells the player that the move they chose is invalid.
	 */
	public void AskForMove();
	/*
	 * Tells the player that the move they chose is invalid.
	 */
	public void InvalidMove();
	/*
	 * Tells the player that the input format was incorrect.
	 */
	public void InvalidFormat();
	/*
	 * Declares who the winner of the game is.
	 * @param state - the winner, number of O and number of X.
	 */
	public void DeclareWinner(int[] state);
}
