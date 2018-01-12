package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

/*
 * Main function of the assignment.
 */
public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			GridPane main_root = (GridPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene main_scene = new Scene(main_root, 250, 300);
			main_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Avihai and Dudu Ex6");
			primaryStage.setScene(main_scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
