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
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class StartPage{
	public VBox root;
	public Scene scene;
	private Image backgroundImage;
	private BackgroundImage background;
	private int i =1;
	public static AudioClip bgSong = new AudioClip(ClassLoader.getSystemResource("audio/openingsound.mp3").toString());
	
	public static Scene getStartPageScene() {
		StartPage page = new StartPage();
		page.initializeStartPage();
		return page.scene;
	}
	
	public void initializeStartPage(){
		 root = new VBox(10);
	     root.setPadding(new Insets(20));
	     root.setAlignment(Pos.CENTER_LEFT);
	     bgSong.setCycleCount(10);
	     bgSong.play();
	     //Set background image
	     backgroundImage = new Image((String) ClassLoader.getSystemResource("opening/Opening0.png").toString());
	     background = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	     root.setBackground(new Background(background));
	     
	     Thread t =new Thread(() -> {  	 
	    	 while(true) {
	    		 i=i%3;
	    		 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
	    		 
	    		 Platform.runLater(() -> {
	    			 backgroundImage = new Image((String) ClassLoader.getSystemResource("opening/Opening"+i+".png").toString());
		    	     background = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		    	     root.setBackground(new Background(background));
	    		 });
	    		 i+=1;
	    		 
	    	 }
	     });
	     t.start();
	     // Game logo
//	     Image logoImage = new Image("logo.png");
//	     ImageView logoImageView = new ImageView(logoImage);

	     Button startButton = new Button("Start Game");
	     startButton.setStyle("-fx-font-size:20");
	     startButton.setTranslateX(150);
	     startButton.setTranslateY(20);
	     startButton.setPrefSize(200, 50);
	     startButton.setOnAction(e -> {
	    	 Stage thisStage = (Stage) (startButton.getScene().getWindow());
			    try {
					thisStage.setScene(SelectPage.getSelectScene());
					t.interrupt();
				} catch (IOException e1) {
				}
			});

	     Button exit = new Button("Exit");
	     exit.setStyle("-fx-font-size:20");
	     exit.setPrefWidth(120);
	     exit.setTranslateX(150);
	     exit.setTranslateY(30);
	     exit.setOnAction(e -> {
	    	 bgSong.stop();	
	    	 t.interrupt();
				Platform.exit();
			});
		exit.setPrefSize(200, 50);
	     // Add elements to the layout
	     root.getChildren().addAll(startButton,exit);

	     // Create the scene and set it on the stage
	     scene = new Scene(root, 800, 600);

	}
	
}
