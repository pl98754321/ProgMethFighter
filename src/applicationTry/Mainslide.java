package applicationTry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Mainslide extends Application {
	@Override
	public void start(Stage primaryStage){
	try {
		Parent root = FXMLLoader.load(this.getClass().getResource("FXML.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch (Exception e) {
		System.out.println("out");
		e.printStackTrace();
	}
	
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

