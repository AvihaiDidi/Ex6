package application;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class GameController {
	@FXML
	private HBox root;
	
	public void initialize() {
		Settings s = new Settings("settings.txt");
		s.load();
		Board b = new Board(s.width, s.height);
		b.SetUpGame();
		BoardDisplay display = new BoardDisplay(s);
		//ConsoleDisplay display = new ConsoleDisplay();
		display.setPrefHeight(500);
		display.setPrefWidth(450);
		root.getChildren().add(0, display);
		PlayerHumanLocal p1 = new PlayerHumanLocal();
		PlayerHumanLocal p2 = new PlayerHumanLocal();
		Rules r = new Rules(b);
		Game g = new Game(b, r, s);
		display.PrintBoard(b);
		//g.RunGame(p1, p2, display);
	}

}
