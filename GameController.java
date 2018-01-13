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
		InputListener in = new InputListener();
		BoardDisplay display = new BoardDisplay(s, in);
		//ConsoleDisplay display = new ConsoleDisplay();
		display.setPrefHeight(500);
		display.setPrefWidth(500);
		root.getChildren().add(0, display);
		Rules r = new Rules(b);
		Game g = new Game(b, r, s, in);
		display.PrintBoard(b);
		g.RunGame(display);
	}
	public void press() {
		System.out.println("press test");
	}
}
