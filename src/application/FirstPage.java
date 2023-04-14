package application;

import java.io.IOException;

import StageSelection.SSController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class FirstPage extends Application {
	public void start(final Stage primaryStage) throws IOException {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(15);
		root.setVgap(15);
		final Button start = new Button("------START------");
		
		start.setOnMouseEntered(e -> {
			start.setPrefWidth(start.getWidth()*5/3);
			start.setPrefHeight(start.getHeight()*5/3);
		});
		start.setOnMouseExited(e -> {
			start.setPrefWidth(start.getWidth()*3/5);
			start.setPrefHeight(start.getHeight()*3/5);
		});
		Button history = new Button("HALL OF FRAME");
		history.setOnAction(e -> {
			System.out.println("switch to history page");
		});

		root.add(start,0,0);
		root.add(history,0,1);
		Scene scene =new Scene(root,800,600);
		FXMLLoader loader = new FXMLLoader(Thread.currentThread().getContextClassLoader().getResource("SSFXML.fxml"));
		Parent root2 = loader.load();
		Scene scene2 = new Scene(root2,800,600);
		final SSController myController = loader.getController();
		scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
					case A:
						myController.slideleft();
						break;
					case D:
						myController.slideright();	
						break;
					case S:
						myController.toGamePlay();	
						break;	
					default:
						break;
					}
				}
			
		});
		
		
		start.setOnAction(e -> primaryStage.setScene(scene2));
		primaryStage.setTitle("ProgMeth Fighter"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
