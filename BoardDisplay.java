package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
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
					this.add(new Rectangle(cellWidth, cellHeight, Color.GRAY), i, j);
				} else {
					if (b.get(i, j) == 1) {
						this.add(new Circle(cellWidth, cellHeight, 28, this.s.p1c), i, j);
					} else if (b.get(i, j) == 2) {
						this.add(new Circle(cellWidth, cellHeight, 28, this.s.p2c), i, j);
					} else {
						System.out.println("Error while printing board.");
					}
				}
			}
		}
		
		
		
		
		
		/*
		int height = (int)this.getPrefHeight();
		int width = (int)this.getPrefWidth();

		int cellHeight = height / this.rows;
		int cellWidth = width / this.cols;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (b.get(i, j) == 0) {
					this.add(new Rectangle(cellWidth, cellHeight,
							Color.GREEN), j, i);
				} else if(b.get(i, j) == 1) {
					this.add(new Circle(cellWidth, cellHeight,
							20, this.p1c), j, i);
				} else if(b.get(i, j) == 2) {
					this.add(new Circle(cellWidth, cellHeight,
							20, Color.WHITE), j, i);
				}
			} 
		}*/
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
