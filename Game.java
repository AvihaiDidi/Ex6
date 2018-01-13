package application;

import java.util.concurrent.TimeUnit;

/*
 * Manages the game itself, uses the Rules class to determine what moves are
 *  possible and then gets moves from player objects and determines using the
 *   Rules class how those moves should affect the game.
 */
public class Game {
	Board board;
	Rules rules;
	Settings settings;
	InputListener in;
	/*
	 * Constructor, adds references to the board the game will be played on and
	 *  the rules that will be used to determine the way the game behaves.
	 *  @param b - the board the game will be played on.
	 *  @param r - the rules that judge the behavior of the game.
	 */
	public Game(Board b, Rules r, Settings settings, InputListener in) {
		this.board = b;
		this.rules = r;
		this.settings = settings;
		this.in = in;
	}
	/*
	 * The main function of the whole program. Manages the actual game.
	 * @param p1 - Class that controls the black pieces.
	 * @param p2 - Class that controls the white pieces.
	 * @param d - Outputs the state of the game visually.
	 */
	void RunGame(Display d) {
		int move, turn = 3 - settings.starter;
		int no_move_flag = 0;
		int[] moves;
		int[] state = rules.CheckBoardState();
		while (state[0] == 0) {
			turn = 3 - turn;
			move = -1;
			moves = rules.PossibleMoves(turn);
			d.Print(board, turn, moves);
			if (moves[0] == 0) {
				//no possible moves, switch to other player.
				if (no_move_flag == 0) {
					no_move_flag = 1;
				} else {
					break;
				}
			} else {
				no_move_flag = 0;
				while (in.get().equals("")) {
					System.out.println("press test");
					try {
						TimeUnit.MILLISECONDS.sleep(16);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String[] split = in.get().split(" ");
				SetPiece(turn, Integer.parseInt(split[0]), Integer.parseInt(split[1]));
				in.set("");
			}
			state = rules.CheckBoardState();
		}
		if (no_move_flag == 0) {
			d.PrintBoard(board);
		}
		d.DeclareWinner(state);
	}
	/*
	 * Places a piece and flips adj pieces according to the rules.
	 * It is assumes the place the piece is set in is valid.
	 * @param color - the color of the piece being placed.
	 * @param x - x cord to be placed at.
	 * @param y - y cord to be placed at.
	 * @return 0 if the piece couldn't be placed, 1 otherwise.
	 */
	private void SetPiece(int color, int x, int y) {
		board.set(x, y, color);
		//Check all adjacent spaces
		Crawl(color, x, y, 1, rules.CrawlCheck(color, x, y, 1));
		Crawl(color, x, y, 2, rules.CrawlCheck(color, x, y, 2));
		Crawl(color, x, y, 3, rules.CrawlCheck(color, x, y, 3));
		Crawl(color, x, y, 4, rules.CrawlCheck(color, x, y, 4));
		Crawl(color, x, y, 6, rules.CrawlCheck(color, x, y, 6));
		Crawl(color, x, y, 7, rules.CrawlCheck(color, x, y, 7));
		Crawl(color, x, y, 8, rules.CrawlCheck(color, x, y, 8));
		Crawl(color, x, y, 9, rules.CrawlCheck(color, x, y, 9));
	}
	/*
	 * Places a specified amount of pieces in a given direction starting from (x,y).
	 * Ignores starting point.
	 * Directions are based on the numpad.
	 * @param color - the color of the piece being placed.
	 * @param x - x cord to be placed at.
	 * @param y - y cord to be placed at.
	 * @param direction - the direction go travel in.
	 * @param amount - the ammout of nodes to flip.
	 */
	private void Crawl(int color, int x, int y, int direction, int amount) {
		int cx = x;
		int cy = y;
		for (int i = 0; i < amount; i++) {
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
			board.set(cx, cy, color);
		}
	}
}
