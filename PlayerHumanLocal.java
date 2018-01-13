package application;
/*
 * A type of player whose input is acquired trough a local keyboard.
 */
public class PlayerHumanLocal implements Player{
	/*
	 * Returns the index of the desired move in the movelist.
	 * @param moves - the move list
	 * @return the desired index. -1 if the choice made was not in the list.
	 * -2 if the input format was invalid.
	 */
	public int GetMove(int[] moves) {
		return 1;
	}

}