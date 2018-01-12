package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root,250,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			GridPane options_root = (GridPane)FXMLLoader.load(getClass().getResource("OptionsMenu.fxml"));
			Scene options_scene = new Scene(options_root,600,400);
			
			primaryStage.setTitle("Avihai and Dudu Ex6");
			primaryStage.setScene(options_scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
