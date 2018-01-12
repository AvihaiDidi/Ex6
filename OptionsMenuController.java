package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

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
	public void Cancel() {
		System.out.println("Cancel");
	}
	public void SaveAndQuit() {
		Settings s = new Settings("settings.txt");
		s.starter = starter.getValue();
		s.p1c = p1c.getValue();
		s.p2c = p2c.getValue();
		s.width = width.getValue();
		s.height = height.getValue();
		s.save();
		System.out.println("SaveAndQuit");
	}
}
