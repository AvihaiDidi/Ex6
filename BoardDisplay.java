package application;



import java.io.IOException;



import javafx.fxml.FXMLLoader;

import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;

import javafx.scene.shape.*;



public class BoardDisplay extends GridPane {

	Settings s;

	Game g;

	

	public BoardDisplay(Settings s, Game g) {

		this.s = s;

		this.g = g;

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoardDisplay.fxml"));

		fxmlLoader.setRoot(this);

		fxmlLoader.setController(this);



		try {

			fxmlLoader.load();

		} catch (IOException exception) {

			throw new RuntimeException(exception);

		}

	}



	public void Print() {

		this.getChildren().clear();

		int[] moves = g.getMoves();

		PrintBoard();

		for(int i = 0; i < moves.length / 2; i++) {

			this.getChildren();

		}

	}

	private void PrintBoard() {

		int height = (int)this.getPrefHeight();

		int width = (int)this.getPrefWidth();



		int cellHeight = height / this.s.getRows();

		int cellWidth = width / this.s.getCols();

		for (int j = 1; j <= this.s.getRows(); j++) {

			for (int i = 1; i <= this.s.getCols(); i++) {

				if (g.getBoard().get(i, j) == 0) {

					Color color = Color.GREY;

					int[] moves = g.getMoves();

					for(int a = 1; a < moves[0]; a+=2) {

						if(moves[a] == i && moves[a+1] == j) {

							color = Color.BURLYWOOD;

						}

					}

					Rectangle b_rec = new Rectangle(cellWidth, cellHeight, color);

					b_rec.setId(i + " " + j);

					b_rec.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

						g.press(b_rec.getId());

						Print();

					});

					this.add(b_rec, i, j);

				} else {

					int life = g.checkLife();

					if(life != 0) {

						DeclareWinner(life);

						return;

					}

					Rectangle rec;

					if (g.getBoard().get(i, j) == 1) {

						rec = new Rectangle(cellWidth, cellHeight, this.s.p1c);

						this.add(rec, i, j);

					} else if (g.getBoard().get(i, j) == 2) {

						rec = new Rectangle(cellWidth, cellHeight, this.s.p2c);

						this.add(rec, i, j);

					} else {

						System.out.println("Error while printing board.");

					}

				}

			}

		}

	}



	public void DeclareWinner(int winner) {

		if(winner == 3) {

			Alert alert = new Alert(AlertType.INFORMATION);

			alert.setTitle("Game Ended");

			alert.setHeaderText(null);

			alert.setContentText("its a tie!");



			alert.showAndWait();

			return;

		}

		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("Game Ended");

		alert.setHeaderText(null);

		alert.setContentText("Player " + winner + " wins!");



		alert.showAndWait();

		

	}



}