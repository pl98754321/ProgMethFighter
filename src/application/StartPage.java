package application;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartPage{
	public VBox root;
	public Scene scene;
	
	public static Scene getStartPageScene() {
		StartPage page = new StartPage();
		page.initializeStartPage();
		return page.scene;
	}
	
	public void initializeStartPage(){
		 root = new VBox(10);
	     root.setPadding(new Insets(20));
	     root.setAlignment(Pos.CENTER);

	     //Set background image
	     Image backgroundImage = new Image((String) ClassLoader.getSystemResource("Stage 2.png").toString());
	     BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	     root.setBackground(new Background(background));

	     // Game logo
//	     Image logoImage = new Image("logo.png");
//	     ImageView logoImageView = new ImageView(logoImage);

	     // Start button
	     Button startButton = new Button("Start Game");
	     startButton.setPrefSize(200, 50);
	     startButton.setOnAction(e -> {
	    	 Stage thisStage = (Stage) (startButton.getScene().getWindow());
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
		something.setPrefSize(200, 50);
	     // Add elements to the layout
	     root.getChildren().addAll(startButton,something);

	     // Create the scene and set it on the stage
	     scene = new Scene(root, 800, 600);
		
		
		
		
		// myself
//		root = new GridPane();
//		root.setAlignment(Pos.CENTER);
//		root.setHgap(15);
//		root.setVgap(15);
//		Button start = new Button("------START------");
//		start.getStyleClass().add("start");
//		start.setPrefWidth(120);
//		start.setOnMouseEntered(e -> {
//			start.setPrefWidth(start.getWidth()*5/4);
//			start.setPrefHeight(start.getHeight()*5/4);
//			start.setCursor(Cursor.HAND);
//		});
//		start.setOnMouseExited(e -> {
//			start.setPrefWidth(start.getWidth()*4/5);
//			start.setPrefHeight(start.getHeight()*4/5);
//			
//		});
//		start.setOnAction(e -> {
//		    Stage thisStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//		    try {
//				thisStage.setScene(SelectPage.getSelectScene());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});
//		
//		Button something = new Button("something");
//		something.setPrefWidth(120);
//		something.setOnAction(e -> {
//			System.out.println("something");
//		});
//
//		root.add(start,0,0);
//		root.add(something,0,1);
//		scene = new Scene(root,800,600);
//		scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
	}
	
}
