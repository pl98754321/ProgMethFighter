package application;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class StartPage{
	public GridPane root;
	public Scene scene;
	
	public static Scene getStartPageScene() {
		StartPage page = new StartPage();
		page.initializeStartPage();
		return page.scene;
	}
	
	public void initializeStartPage(){
		root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(15);
		root.setVgap(15);
		Button start = new Button("------START------");
		start.getStyleClass().add("start");
		start.setPrefWidth(120);
		start.setOnMouseEntered(e -> {
			start.setPrefWidth(start.getWidth()*5/4);
			start.setPrefHeight(start.getHeight()*5/4);
			start.setCursor(Cursor.HAND);
		});
		start.setOnMouseExited(e -> {
			start.setPrefWidth(start.getWidth()*4/5);
			start.setPrefHeight(start.getHeight()*4/5);
			
		});
		start.setOnAction(e -> {
		    Stage thisStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		    try {
				thisStage.setScene(SelectPage.getSelectScene());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Button something = new Button("something");
		something.setPrefWidth(120);
		something.setOnAction(e -> {
			System.out.println("something");
		});

		root.add(start,0,0);
		root.add(something,0,1);
		scene = new Scene(root,800,600);
		scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
	}
}
