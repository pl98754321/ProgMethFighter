package StageSelection;

import application.GPController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;



public class StageSelection extends Application {
	@Override
	public void start(Stage primaryStage){
	try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SSFXML.fxml"));
		Parent root = loader.load();
		final SSController myController = loader.getController();
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
		
		
		primaryStage.setTitle("ProgMeth Fighter");
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		launch(args);
	}
}

