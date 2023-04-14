package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import Entity.Player;
import java.util.*;

public class GamePlay extends Application{
	private Player player;
	private Map<KeyCode, Boolean> keys = new HashMap<>();
	
	@Override
	public void start(Stage stage){
		
		
		StackPane pane = new StackPane();
		Canvas canvas = new Canvas(800, 600);
		canvas.setFocusTraversable(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		pane.getChildren().add(canvas);
		
		this.player = new Player(100,50, 50);
		
		Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000.0/40), e -> update(gc)));
		loop.setCycleCount(Animation.INDEFINITE);
		loop.play();

		canvas.setOnKeyPressed(e -> this.keys.put(e.getCode(), true));
		canvas.setOnKeyReleased(e -> this.keys.put(e.getCode(), false));

		
		Scene scene = new Scene(pane, 800, 600);
		stage.setResizable(false);
		stage.setTitle("smooth move");
		stage.setScene(scene);
		stage.show();
	}
	

	public static void main(String[] args){
		launch(args);
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
		
		
	}
}