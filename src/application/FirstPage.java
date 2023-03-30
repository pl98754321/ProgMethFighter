package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class FirstPage extends Application {
// Override the start method in the Application class
	public void start(Stage primaryStage) {
// Create a scene and place a button in the scene
		Button btn = new Button("Start Game");
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 800, 600);
		
		
		primaryStage.setTitle("ProgMeth Fighter"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
