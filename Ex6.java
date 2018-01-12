package application;
/*
 * Main function of the program.
 */
public class Ex6 {
	public static void main(String[] args) {
		Settings s = new Settings("settings.txt");
		s.load();
		Board b = new Board(s.width, s.height);
		b.SetUpGame();
		ConsoleDisplay d = new ConsoleDisplay();
		PlayerHumanLocal p1 = new PlayerHumanLocal();
		PlayerHumanLocal p2 = new PlayerHumanLocal();
		Rules r = new Rules(b);
		Game g = new Game(b, r, s);
		g.RunGame(p1, p2, d);
	}

}
