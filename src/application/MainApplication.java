package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Entity.Enemy;
import Entity.Player;
import Item.BaseItem;
import Item.Exp;
import Item.Potion;
import StageSelection.SSController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainApplication extends Application {
	private Player player;
	private Map<KeyCode, Boolean> keys = new HashMap<>();
	public static ArrayList<Enemy> enemies = new ArrayList<>();
	public static ArrayList<BaseItem> items = new ArrayList<>();
	public void start(final Stage primaryStage) throws IOException {
		//start page
		GridPane root = new GridPane();
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
		Button something = new Button("something");
		something.setPrefWidth(120);
		something.setOnAction(e -> {
			System.out.println("something");
		});

		root.add(start,0,0);
		root.add(something,0,1);
		Scene scene =new Scene(root,800,600);
		scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
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
						spawnEnemies();
						break;	
					default:
						break;
					}
				}
			
		});
		
		GridPane root4 = new GridPane();
		root4.setBackground(Background.fill(Color.GRAY));
		root4.setAlignment(Pos.CENTER);
		root4.setHgap(15);
		root4.setVgap(15);
		
		Text lose = new Text("YOU LOSE");
		lose.setFont(Font.font(50));
		lose.setFill(Color.RED);
		Button restart = new Button("----RESTART----");
		restart.setOnMouseClicked(e -> {
			player = new Player(100,350, 250);
			this.keys.clear();
			this.items.clear();
			this.enemies.clear();
			primaryStage.setScene(scene3);
			spawnEnemies();

			
		});
		Button menu = new Button(" -MAIN MENU- ");
		menu.setOnMouseClicked(e -> {
			player = new Player(100,350, 250);
			player.setX(350);
			player.setY(250);
			this.keys.clear();
			this.items.clear();
			this.enemies.clear();
			primaryStage.setScene(scene);

			
		});
		root4.add(lose, 0, 0,2,1);
		root4.add(restart,0,1);
		root4.add(menu,1,1);
		Scene scene4 =new Scene(root4,800,600);
		
		
		
		
		start.setOnAction(e -> primaryStage.setScene(scene2));
		primaryStage.setTitle("ProgMeth Fighter"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.setResizable(false);
		primaryStage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				if(player.getHp()>0) {
					update(gc);
				}
				else {
					primaryStage.setScene(scene4);
				}
			}
		};
		animation.start();
	}
	private void spawnEnemies(){
		Thread spawner = new Thread(() -> {
			try {
				Random random = new Random();
				while (true){
					this.enemies.add(new Enemy(this.player, (int)( random.nextDouble()*800), (int)( random.nextDouble()*600)));
					Thread.sleep(700);
					if(player.getHp()<=0) {
						return;
					}
				}
			} catch (InterruptedException ex){
			}
		});
		spawner.setDaemon(true);
		spawner.start();
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
		
		for (int i = 0; i < this.items.size(); i++){
			BaseItem item=items.get(i);
			item.render(gc);
			if(item.collided(player.getX(), player.getY(), 10,40)){
				item.performEffect(player);
				items.remove(i);
			}
		}
		
		for (int i = 0; i < enemies.size(); i++){
			Enemy e = enemies.get(i);
			e.render(gc);
			for (int j = 0; j < Player.bullets.size(); j++){
				if (e.collided(Player.bullets.get(j).getX(), Player.bullets.get(j).getY(),40,20)){
					Player.bullets.remove(j);
					enemies.remove(i);
					items.add(new Exp(e.getX(),e.getY()));
					if(Math.random()<=0.2) {
						items.add(new Potion(e.getX(),e.getY()));
					}
					i++;
					break;
				}
			}
		}
		
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
		//exp 
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(30, 50, this.player.getCurrentExp()*200/player.getNextLv(), 10);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(30, 50, 200, 10);
		
		gc.setFill(Color.BLACK);
		gc.fillText("Lv : "+player.getLv()+" EXP : "+player.getCurrentExp()+"/"+player.getNextLv(),240 ,60);
	
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
