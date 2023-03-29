package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException  {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("TryFXML.fxml"));
			Parent root = loader.load();
			MyController MyController = loader.getController();
			Scene scene = new Scene(root);
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					// TODO Auto-generated method stub
					switch(event.getCode()) {
						case W:
							MyController.moveUp();
							break;
						case S:
							MyController.moveDown();
							break;
						case A:
							MyController.moveLeft();
							break;
						case D:
							MyController.moveRight();	
							break;
						default:
							break;
						}
					}
				
			});
			primaryStage.setScene(scene);
			primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
