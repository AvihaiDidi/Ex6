/*
 * Main function of the program.
 */
public class Ex6 {
	public static void main(String[] args) {
		Board b = new Board(8, 8);
		b.SetUpGame();
		ConsoleDisplay d = new ConsoleDisplay();
		PlayerHumanLocal p1 = new PlayerHumanLocal();
		PlayerHumanLocal p2 = new PlayerHumanLocal();
		Rules r = new Rules(b);
		Game g = new Game(b, r);
		g.RunGame(p1, p2, d);
	}

}
