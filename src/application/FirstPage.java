package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Entity.Player;
import StageSelection.SSController;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FirstPage extends Application {
	private Player player;
	private Map<KeyCode, Boolean> keys = new HashMap<>();
	public void start(final Stage primaryStage) throws IOException {
		//start page
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(15);
		root.setVgap(15);
		final Button start = new Button("------START------");
		
		start.setOnMouseEntered(e -> {
			start.setPrefWidth(start.getWidth()*5/4);
			start.setPrefHeight(start.getHeight()*5/4);
		});
		start.setOnMouseExited(e -> {
			start.setPrefWidth(start.getWidth()*4/5);
			start.setPrefHeight(start.getHeight()*4/5);
		});
		Button history = new Button("HALL OF FRAME");
		history.setOnAction(e -> {
			System.out.println("switch to history page");
		});

		root.add(start,0,0);
		root.add(history,0,1);
		Scene scene =new Scene(root,800,600);
		//gameplay page
				StackPane root3 = new StackPane();
				Canvas canvas = new Canvas(800, 600);
				canvas.setFocusTraversable(true);
				GraphicsContext gc = canvas.getGraphicsContext2D();
				root3.getChildren().add(canvas);
				
				this.player = new Player(100,350, 250);

				canvas.setOnKeyPressed(e -> this.keys.put(e.getCode(), true));
				canvas.setOnKeyReleased(e -> this.keys.put(e.getCode(), false));
				canvas.setOnMouseClicked(e -> this.player.shoot(e.getX(), e.getY()));
				
				Scene scene3 = new Scene(root3, 800, 600);
		
		//select stage page
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
						primaryStage.setScene(scene3);
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
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				// TODO Auto-generated method stub
				update(gc);
			}
		};
		animation.start();
	}
	public static void shedule(long time, Runnable r){
		new Thread(() -> {
			try {
				Thread.sleep(time);
				r.run();
			} catch (InterruptedException ex){
			}
		}).start();
	}
	private void update(GraphicsContext gc){
		gc.clearRect(0, 0, 800, 600);
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 800, 600);
		
		this.player.render(gc);

		if (this.keys.getOrDefault(KeyCode.W, false)){
			this.player.move(0, -player.SPEED);
		}
		if (this.keys.getOrDefault(KeyCode.A, false)){
			this.player.move(-player.SPEED, 0);
		}
		if (this.keys.getOrDefault(KeyCode.S, false)){
			this.player.move(0, player.SPEED);
		}
		if (this.keys.getOrDefault(KeyCode.D, false)){
			this.player.move(player.SPEED, 0);
		}
		//HP 
		gc.setFill(Color.FORESTGREEN);
		gc.fillRect(30, 20, this.player.getHp()*250/100, 30);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(30, 20, 250, 30);
		
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(30, 50, this.player.getCurrentExp()*200/100, 10);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(30, 50, 200, 10);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
