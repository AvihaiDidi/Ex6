package application;


import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GameController {
	@FXML
	private HBox root;
	@FXML
	private Text curPlayer;
	@FXML
	private Text p1Score;
	@FXML
	private Text p2Score;

	public void initialize() {
		Settings s = new Settings("settings.txt");
		s.load();
		Stats stats = new Stats(curPlayer, p1Score, p2Score);
		stats.updateStat(s.starter, 2, 2);
		Board b = new Board(s.width, s.height);
		b.SetUpGame();
		Rules r = new Rules(b);
		Game g = new Game(b, r, s, stats);
		BoardDisplay display = new BoardDisplay(s, g);
		display.setPrefHeight(500);
		display.setPrefWidth(500);
		root.getChildren().add(0, display);
		display.Print();
	}
	public void press() {
		System.out.println("press test");
	}
	
}