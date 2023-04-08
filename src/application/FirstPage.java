package application;

import java.io.IOException;

import StageSelection.SSController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class FirstPage extends Application {
// Override the start method in the Application class
	public void start(final Stage primaryStage) throws IOException {
// Create a scene and place a button in the scene
		Button btn = new Button("Start Game");
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 800, 600);
		
		FXMLLoader loader = new FXMLLoader(Thread.currentThread().getContextClassLoader().getResource("SSFXML.fxml"));
		Parent root2 = loader.load();
//		final GPController myController = loader.getController();
		Scene scene2 = new Scene(root2,800,600);
		final SSController myController = loader.getController();
		scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				switch(event.getCode()) {
					case A:
						myController.slide();
						break;
					case D:
						myController.slide();	
						break;
					case S:
						myController.toGamePlay();	
						break;	
					default:
						break;
					}
				}
			
		});
		
		btn.setOnAction(e -> primaryStage.setScene(scene2));
		
		primaryStage.setTitle("ProgMeth Fighter"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
