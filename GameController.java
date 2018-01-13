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
		Rules r = new Rules(b);
		Game g = new Game(b, r, s);
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
