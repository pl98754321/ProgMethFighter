package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;


public class GamePlay extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException  {
			Rectangle rec = new Rectangle();
			rec.setX(50);
			rec.setY(50);
			rec.setHeight(50);
			rec.setWidth(50);
		    
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GPFXML.fxml"));
			Parent root = loader.load();
			final GPController myController = loader.getController();
			Scene scene = new Scene(root,800,600);
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					// TODO Auto-generated method stub
					switch(event.getCode()) {
						case W:
							myController.moveUp();
							break;
						case S:
							myController.moveDown();
							break;
						case A:
							myController.moveLeft();
							break;
						case D:
							myController.moveRight();	
							break;
						default:
							break;
						}
					}
				
			});
			primaryStage.setTitle("ProgMeth Fighter");
			primaryStage.setScene(scene);
			primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
