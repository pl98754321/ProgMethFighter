package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Bullet.Bullet;
import Entity.Boss;
import Entity.Enemy;
import Entity.MapImage;
import Entity.Player;
import Item.BaseItem;
import Item.Magnet;
import StageSelection.SSController;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class GamePlayPage {
	public StackPane root3;
	public Canvas canvas;
	public Scene scene3;
	private Player player;
	public static MapImage background;
	public static Map<KeyCode, Boolean> keys = new HashMap<>();
	public static ArrayList<Enemy> enemies = new ArrayList<>();
	public static ArrayList<BaseItem> items = new ArrayList<>();
	public static ArrayList<Bullet> bullets = new ArrayList<>();
	private Boss boss;
	AudioClip explosion = new AudioClip(ClassLoader.getSystemResource("audio/Explosion.wav").toString());
	
	
	public static Scene getGamePlayPage() {
		GamePlayPage page = new GamePlayPage();
		page.initializeGamePlayPage();
		return page.scene3;
	}
	
	public void initializeGamePlayPage(){
		root3 = new StackPane();
		canvas = new Canvas(800, 600);
		canvas.setFocusTraversable(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root3.getChildren().add(canvas);
		this.player = new Player(400,  300);
		
		this.boss=new Boss(player,350,250);
		if(SSController.selectedStage()==1) {
			background =new MapImage(ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString(),0,0);
		}
		else if(SSController.selectedStage()==2) {
			background =new MapImage(ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString(),0,0);
		}
		else{
			background =new MapImage(ClassLoader.getSystemResource("Map/chillbeach.png").toString(),0,0);
		}
		canvas.setOnKeyPressed(e -> GamePlayPage.keys.put(e.getCode(), true));
		canvas.setOnKeyReleased(e -> GamePlayPage.keys.put(e.getCode(), false));
		canvas.setOnMouseClicked(e -> this.player.shoot((int) (e.getX()), (int)(e.getY())));
		scene3 = new Scene(root3, 800, 600);
		Thread spawner = new Thread(() -> {
			try {
				Random random = new Random();
				while (true){
					GamePlayPage.enemies.add(new Enemy(this.player,(int) (GamePlayPage.background.getHeight()*random.nextDouble()),(int) (GamePlayPage.background.getWidth()*random.nextDouble())));
					Thread.sleep(500);
					if(player.getHp()<=0) {
						Thread.currentThread().interrupt();
						return;
					}
				}
			} catch (InterruptedException ex){
			}
		});
		spawner.start();
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				if(boss.getHp()<=0) {
					Stage thisStage = (Stage) scene3.getWindow();
					thisStage.setScene(ResultPage.getResultPage(1));
					spawner.interrupt();
					stop();
				}
				else if(player.getHp()==0) {
					Stage thisStage = (Stage) scene3.getWindow();
					thisStage.setScene(ResultPage.getResultPage(0));
					spawner.interrupt();
					stop();
				}
				else{
					update(gc);
				}
			}
		};
		animation.start();
	}
	private void update(GraphicsContext gc){
		gc.clearRect(0, 0, 800, 600);
		gc.drawImage(background, background.getX(), background.getY(),background.getWidth(),background.getHeight());;
		
		for (Bullet a :bullets){
			a.render(gc);
		}
	
		for (int i = 0; i < GamePlayPage.items.size(); i++){
			BaseItem item = GamePlayPage.items.get(i);
			item.render(gc);
			if(item.distance(player)<=0){
				item.performEffect(player);
				if(item instanceof Magnet) {
					break;
				}
				GamePlayPage.items.remove(item);
			}
		}
		for (int i = 0; i < enemies.size(); i++){
			Enemy e = enemies.get(i);
			e.render(gc);
			for (int j = 0; j < bullets.size(); j++){
				if (e.distance(bullets.get(j))<=0){
					bullets.remove(j);
					enemies.remove(i);
					explosion.play();
					e.dropItem(items);
					i++;
					break;
				}
			}
		}
		
		this.player.render(gc);
		
		if(player.getLv()>=15) {
			this.boss.render(gc);
			gc.setFill(Color.RED);
			gc.fillRect(520, 20, (this.boss.getHp()*250/this.boss.getMaxHP()), 30);
			gc.setStroke(Color.BLACK);
			gc.strokeRect(520, 20, 250, 30);
			for (int j = 0; j < bullets.size(); j++){
				if (boss.distance(bullets.get(j))<=0){
					bullets.remove(j);
					boss.takeDamage(this.player.getAtk());
					break;
				}
			}
		}
		
		if (GamePlayPage.keys.getOrDefault(KeyCode.W, false)){
			this.player.move(0, -player.SPEED);
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.A, false)){
			this.player.move(-player.SPEED, 0);
			}
		if (GamePlayPage.keys.getOrDefault(KeyCode.S, false)){
			this.player.move(0, player.SPEED);
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.D, false)){
			this.player.move(player.SPEED, 0);
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.E, false)){
			this.player.iAmAtomic(enemies);;
		}
			//HP 
		int hp =this.player.getHp();
		if(hp>=75) {
			gc.setFill(Color.FORESTGREEN);
		}
		else if(hp>=50) {
			gc.setFill(Color.YELLOW);
		}
		else if(hp>=25) {
			gc.setFill(Color.ORANGE);
		}
		else {
			gc.setFill(Color.RED);
		}
		gc.fillRect(30, 20, this.player.getHp()*250/100, 30);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(30, 20, 250, 30);
		
		gc.setFill(Color.BLACK);
		gc.fillText("HP : "+player.getHp()+" / "+100,290 ,50);
		//EXP
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(30, 50, this.player.getCurrentExp()*200/player.getNextLv(), 10);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(30, 50, 200, 10);
		
		gc.setFill(Color.BLACK);
		gc.fillText("Lv : "+player.getLv()+" EXP : "+player.getCurrentExp()+"/"+player.getNextLv(),240 ,60);
	
		if(player.isUltiReady()) {
			gc.setFill(Color.BLACK);
			gc.fillText("can use ultimate skill",30,70);
		}
	}
	public static void coolDown(long time, Runnable r){
		new Thread(() -> {
			try {
				Thread.sleep(time);
				r.run();
			} catch (InterruptedException ex){
			}
		}).start();
	}
}
