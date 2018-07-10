package application;
/*
 * This class determines what moves are possible and what constitutes a victory.
 */
public class Rules {
	private Board board;
	/*
	 * Constructor - just gets a reference to a board.
	 * @param gameBoard - the board to reference.
	 */
	public Rules(Board board) {
		this.board = board;
	}
	/*
	 * Returns a list of possible moves.
	 * @param turn - The player whose turn it is.
	 * @return a list of moves,
	 * the first number is the size of the rest of the list,
	 * which should be a multiple of 2.
	 */
	public int[] PossibleMoves(int turn) {
		//TODO proper dynamic memory allocation ie not this
		int[] l = new int [1 + (2 * board.getWidth() * board.getHeight())];
		int p_index = 1;
		for (int i = 1; i <= board.getWidth(); i++) {
			for (int j = 1; j <= board.getHeight(); j++) {
				if (CheckSpot(turn, i, j)) {
					l[p_index++] = i;
					l[p_index++] = j;
				}
			}
		}
		l[0] = p_index - 1;
		return l;
	}
	/*
	 * Checks which player won.
	 * @param b - The board.
	 * @return the player who won, 0 the game is ongoing.
	 * -1 if an error happened, and 3 if it's a tie.
	 * and also the counts.
	 */
	public int[] CheckBoardState() {
		/*
		 * state[0] winner
		 * state[1] white count
		 * state[2] black count
		 */
		int[] state = new int[3];
		state[0] = state[1] = state[2] = 0;
		for (int i = 1; i <= board.getWidth(); i++) {
			for (int j = 1; j <= board.getHeight(); j++) {
				if (board.get(i, j) == 0) {
					return state;
				}
				if (board.get(i, j) == 1) {
					state[1]++;
				}
				if (board.get(i, j) == 2) {
					state[2]++;
				}
			}
		}
		if (state[2] + state[1] != (board.getWidth()) * (board.getHeight())) {
			state[0] = 0;
		} else if (state[2] > state[1]) {
			state[0] = 2;
		} else if (state[1] > state[2]) {
			state[0] = 1;
		} else {
			state[0] = 3;
		}
		return state;
	}
	/*
	 * Scans the board in the specified direction.
	 * Start position isn't scanned and is assumed to be of the color given.
	 * Directions are based on the numpad.
	 * @param color - the color of the piece being placed.
	 * @param x - x cord to be placed at.
	 * @param y - y cord to be placed at.
	 * @param direction - the direction go travel in.
	 * @return  - the number of pieces whose color should be inverted.
	 */
	public int CrawlCheck(int color, int x, int y, int direction) {
		int cx = x;
		int cy = y;
		int count = 0;
		while (true) {
			switch (direction) {
				case 1:
					cx--;
					cy++;
					break;
				case 2:
					cy++;
					break;
				case 3:
					cx++;
					cy++;
					break;
				case 4:
					cx--;
					break;
				case 6:
					cx++;
					break;
				case 7:
					cx--;
					cy--;
					break;
				case 8:
					cy--;
					break;
				case 9:
					cx++;
					cy--;
					break;
				default:
					//do nothing
					break;
			}
			if (board.get(cx, cy) == 0) {
				return 0;
			}
			if (board.get(cx, cy) + color == 3) {
				count++;
			}
			if ((board.get(cx, cy) + color) % 2 == 0) {
				return count;
			}
		}
	}
	/*
	 * Checks the specified position on the board to see if a piece of
	 * a specified color can be placed there without breaking the rules of the game.
	 * @param color - color of the piece being placed.
	 * @param x - x cord to be placed at.
	 * @param y - y cord to be placed at.
	 * @return 1 if the position is valid, 0 otherwise.
	 */
	private boolean CheckSpot(int color, int x, int y) {
		//Check to see that the piece itself it in a valid location.
		if (InBoard(x, y) && !NotOverlap(x, y)) {
			return false;
		}
		//Check if placing a piece will result in anything being flipped.
		if (!(CrawlCheck(color, x, y, 1) > 0 || CrawlCheck(color, x, y, 2) > 0 ||
			CrawlCheck(color, x, y, 3) > 0 || CrawlCheck(color, x, y, 4) > 0 ||
			CrawlCheck(color, x, y, 6) > 0 || CrawlCheck(color, x, y, 7) > 0 ||
			CrawlCheck(color, x, y, 8) > 0 || CrawlCheck(color, x, y, 9) > 0)) {
			return false;
		}
		return true;
	}
	/*
	 * Checks if the specified position is in the board.
	 * @param x - x cord to be placed at.
	 * @param y - y cord to be placed at.
	 * @return 1 if the position is valid, 0 otherwise.
	 */
	private boolean InBoard(int x, int y) {
		return !(x < 1 || board.getWidth() < x || y < 1 || board.getHeight() < y);
	}
	/*
	 * Checks if the specified position is already occupied.
	 * @param x - x cord to be placed at.
	 * @param y - y cord to be placed at.
	 * @return 1 if the position is valid, 0 otherwise.
	 */
	private boolean NotOverlap(int x, int y) {
		return (board.get(x, y) == 0);
	}
}
