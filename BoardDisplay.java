package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class BoardDisplay extends GridPane implements Display {
	Settings s;
	
	public BoardDisplay(Settings s) {
		this.s = s;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoardDisplay.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void Print(Board b, int turn, int[] moves) {
		this.getChildren().clear();
		PrintBoard(b);
		for(int i = 0; i < moves.length / 2; i++) {
			this.getChildren();
		}
	}


	@Override
	public void PrintBoard(Board b) {
		int height = (int)this.getPrefHeight();
		int width = (int)this.getPrefWidth();

		int cellHeight = height / this.s.getRows();
		int cellWidth = width / this.s.getCols();
		for (int j = 1; j <= this.s.getRows(); j++) {
			for (int i = 1; i <= this.s.getCols(); i++) {
				if (b.get(i, j) == 0) {
					Rectangle b_rec = new Rectangle(cellWidth, cellHeight, Color.GRAY);
					b_rec.setId(i + " " + j);
					b_rec.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
						String[] split = b_rec.getId().split(" ");
						System.out.println("pressed: " + Integer.parseInt(split[0]) + ", " + Integer.parseInt(split[1]));
					});
					this.add(b_rec, i, j);
				} else {
					Rectangle rec;
					if (b.get(i, j) == 1) {
						rec = new Rectangle(cellWidth, cellHeight, this.s.p1c);
						this.add(rec, i, j);
					} else if (b.get(i, j) == 2) {
						rec = new Rectangle(cellWidth, cellHeight, this.s.p2c);
						this.add(rec, i, j);
					} else {
						System.out.println("Error while printing board.");
					}
				}
			}
		}
	}

	@Override
	public void AskForMove() {
		
	}

	@Override
	public void InvalidMove() {
		
	}

	@Override
	public void InvalidFormat() {
		
	}

	@Override
	public void DeclareWinner(int[] state) {
		// TODO Auto-generated method stub

	}

}
