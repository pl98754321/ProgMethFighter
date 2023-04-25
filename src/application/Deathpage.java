package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Deathpage extends Application {
	public void start(Stage primaryStage){
		GridPane root3 = new GridPane();
		root3.setAlignment(Pos.CENTER);
		root3.setHgap(15);
		root3.setVgap(15);
		Button restart = new Button("----RESTART----");
		
		restart.setOnMouseEntered(e -> {
			restart.setPrefWidth(restart.getWidth()*5/4);
			restart.setPrefHeight(restart.getHeight()*5/4);
		});
		restart.setOnMouseExited(e -> {
			restart.setPrefWidth(restart.getWidth()*4/5);
			restart.setPrefHeight(restart.getHeight()*4/5);
		});
		Button menu = new Button(" -MAIN MENU- ");
		menu.setOnAction(e -> {
			
		});

		root3.add(restart,0,0);
		root3.add(menu,0,1);
		Scene scene =new Scene(root3,800,600);
		primaryStage.setTitle("ProgMeth Fighter");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

