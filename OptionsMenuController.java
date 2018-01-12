package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/*
 * A controller for the options menu.
 */
public class OptionsMenuController {
	ObservableList<Integer> starterList = FXCollections.observableArrayList(1, 2);
	ObservableList<Integer> widthList = FXCollections.observableArrayList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
	ObservableList<Integer> heightList = FXCollections.observableArrayList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
	@FXML
	private ChoiceBox<Integer> starter;
	@FXML
	private ColorPicker p1c;
	@FXML
	private ColorPicker p2c;
	@FXML
	private ChoiceBox<Integer> width;
	@FXML
	private ChoiceBox<Integer> height;
	public OptionsMenuController() {
	}
	@FXML
	/*
	 * Initializes the values of the diffrent controllers.
	 */
	private void initialize() {
		Settings s = new Settings("settings.txt");
		s.load();
		starter.setValue(s.starter);
		starter.setItems(starterList);
		p1c.setValue(s.p1c);
		p2c.setValue(s.p2c);
		width.setValue(s.width);
		width.setItems(widthList);
		height.setValue(s.height);
		height.setItems(heightList);
	}
	/*
	 * Discards changes and returns to the main menu.
	 * @param event - the button press event.
	 */
	public void Discard(ActionEvent event) {
		gotoMainMenu(event);
	}
	/*
	 * Saves changes and returns to the main menu.
	 * @param event - the button press event.
	 */
	public void SaveAndQuit(ActionEvent event) {
		Settings s = new Settings("settings.txt");
		s.starter = starter.getValue();
		s.p1c = p1c.getValue();
		s.p2c = p2c.getValue();
		s.width = width.getValue();
		s.height = height.getValue();
		s.save();
		gotoMainMenu(event);
	}
	/*
	 * Returns to the main menu.
	 * @param event - the button press event.
	 */
	private void gotoMainMenu(ActionEvent event) {
		GridPane main_root;
		try {
			main_root = (GridPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene main_scene = new Scene(main_root, 250, 300);
			main_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(main_scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
