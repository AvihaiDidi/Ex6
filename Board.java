package application;
/*
 * The board the game is played on.
 */
public class Board {
	private int[][] b;
	private int width;
	private int height;
	/**
	 * Constructor: Makes the board and fills it with blanks.
	 * @param width - the width of the board.
	 * @param height - the height of the board.
	 */
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		b = new int[height][width];
		for (int i = 0; i < height; i++) {
			b[i] = new int[width];
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				b[i][j] = 0;
			}
		}
	}
	/*
	 * This function returns the value of the board at location (x,y).
	 * @param x : x cord. from 1 to width
	 * @param y : y cord. from 1 to height
	 */
	public int get(int x, int y) {
		if (x <= 0 || width < x || y <= 0 || height < y) {
			return 0;
		}
		return b[y - 1][x - 1];
	}
	/*
	 * Returns the width of the board.
	 * @return - width of the board.
	 */
	public int getWidth() {
		return width;
	}
	/*
	 * Returns the height of the board.
	 * @return - height of the board.
	 */
	public int getHeight() {
		return height;
	}
	/*
	 * This function sets the value of the board at location (x,y).
	 * @param x - x cord. from 1 to width
	 * @param y - y cord. from 1 to height
	 * @param value - the value to be set.
	 */
	public void set(int x, int y, int value) {
		if (!(x <= 0 || width < x || y <= 0 || height < y)) {
			b[y - 1][x - 1] = value;
		}
	}
	/**
	 * This function places the initial 4 pieces on a 8x8 game.
	 */
	public void SetUpGame() {
		set(width / 2, height / 2, 1);
		set((width / 2) + 1, (height / 2) + 1, 1);
		set(width / 2, (height / 2) + 1, 2);
		set((width / 2) + 1, height / 2, 2);
	}

	public int getScore(int playerNum) {
		int score = 0;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(b[i][j] == playerNum) {
					score++;
				}
			}
		}
		return score;
	}

}