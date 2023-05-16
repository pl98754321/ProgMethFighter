package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	Image backgroundImage;
	BackgroundImage background;
	int i =1;
	
	public static Scene getStartPageScene() {
		StartPage page = new StartPage();
		page.initializeStartPage();
		return page.scene;
	}
	
	public void initializeStartPage(){
		 root = new VBox(10);
	     root.setPadding(new Insets(20));
	     root.setAlignment(Pos.CENTER_LEFT);

	     //Set background image
	     backgroundImage = new Image((String) ClassLoader.getSystemResource("Opening0.png").toString());
	     background = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	     root.setBackground(new Background(background));
	     
	     new Thread(() -> {
	    	 
	    	 while(true) {
	    		 i=i%3;
	    		 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		 Platform.runLater(() -> {
	    			 backgroundImage = new Image((String) ClassLoader.getSystemResource("Opening"+i+".png").toString());
		    	     background = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		    	     root.setBackground(new Background(background));
	    		 });
	    		 i+=1;
	    		 
	    	 }
	     }).start();
	     // Game logo
//	     Image logoImage = new Image("logo.png");
//	     ImageView logoImageView = new ImageView(logoImage);

	     // Start button
	     Button startButton = new Button("Start Game");
	     startButton.setTranslateX(150);
	     startButton.setTranslateY(20);
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
	     something.setTranslateX(150);
	     something.setTranslateY(30);
	     something.setOnAction(e -> {
				System.out.println("something");
			});
		something.setPrefSize(200, 50);
	     // Add elements to the layout
	     root.getChildren().addAll(startButton,something);

	     // Create the scene and set it on the stage
	     scene = new Scene(root, 800, 600);
		
		
		
		
		
	}
	
}
