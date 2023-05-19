package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MainApplication extends Application {
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("ProgMeth Fighter"); // Set the stage title
		primaryStage.setScene(StartPage.getStartPageScene()); // Place the scene
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(e -> {
			StartPage.bgSong.stop();
			Platform.exit();
		});
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
