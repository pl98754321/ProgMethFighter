package page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Controller.SSController;
import entity.MapImage;
import entity.base.BaseBullet;
import entity.base.BaseItem;
import entity.unit.Boss;
import entity.unit.Enemy;
import entity.unit.EnermySpeedter;
import entity.unit.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GamePlayLogic;
import javafx.scene.media.AudioClip;

public class GamePlayPage {
	public StackPane root3;
	public Canvas canvas;
	public Scene scene3;
	private Player player;
	public static MapImage background;
	private Image UtiImage = new Image(ClassLoader.getSystemResource("halo.png").toString());
	public static Map<KeyCode, Boolean> keys = new HashMap<>();
	public static ArrayList<Enemy> enemies = new ArrayList<>();
	public static ArrayList<BaseItem> items = new ArrayList<>();
	public static ArrayList<BaseBullet> bullets = new ArrayList<>();
	private Boss boss;
	private boolean pause =false;
	private boolean pauseDetect = false;
	public  static boolean lvlUp=false;
	public static Scene tempPage;
	public static boolean isback = false;
	
	public static Scene getGamePlayPage() {
		GamePlayPage page = new GamePlayPage();
		page.initializeGamePlayPage();
		return page.scene3;
	}
	public Scene getScene() {return tempPage;}
	
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
		canvas.setOnMouseClicked(e -> {
			if(!isPause()) {
				this.player.shoot((int) (e.getX()), (int)(e.getY()));
			}
		});
		scene3 = new Scene(root3, 800, 600);		
		Thread spawner = GamePlayLogic.getSpawner(this.player);
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
					if(isPause()) {
						if (GamePlayPage.keys.getOrDefault(KeyCode.P, false)){
							resetPause();
						}
						else if(isback) {
							isback=false;
							keys.clear();
							resetPause();
						}
					}
					else {
						if(lvlUp) {
							Stage thisStage = (Stage) scene3.getWindow();
							try {
								tempPage=scene3;
								thisStage.setScene(OptionPage.getOptionScene());
								resetPause();
							} catch (IOException e) {}
						}
						else {
							update(gc);
							}
					}
				}
			}
		};
		animation.start();
	}
	private void update(GraphicsContext gc){
		gc.clearRect(0, 0, 800, 600);
		gc.drawImage(background, background.getX(), background.getY(),background.getWidth(),background.getHeight());
		
		GamePlayLogic.updateBullet(gc,player,bullets);
		GamePlayLogic.updateItems(gc,player,items);
		GamePlayLogic.updateEnemy(gc,player,enemies,bullets,items);
		
		this.player.render(gc);
		
		if(player.getLv()>=5) {
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
			this.player.move(0, -player.getSpeed());
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.A, false)){
			this.player.move(-player.getSpeed(), 0);
			}
		if (GamePlayPage.keys.getOrDefault(KeyCode.S, false)){
			this.player.move(0, player.getSpeed());
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.D, false)){
			this.player.move(player.getSpeed(), 0);
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.E, false)){
			this.player.iAmAtomic(enemies);
		}
		if (GamePlayPage.keys.getOrDefault(KeyCode.P, false)){
			resetPause();
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
			gc.drawImage(UtiImage,30,70,50,50);
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
	public boolean isPause() {
		return pause;
	}

	public void resetPause() {
		if(!this.pauseDetect) {
			this.pause=!(this.isPause());
			this.setPauseDetect(true);
			coolDown(100,() -> this.setPauseDetect(false));
		}
	}

	public boolean isPauseDetect() {
		return pauseDetect;
	}

	public void setPauseDetect(boolean pauseDetect) {
		this.pauseDetect = pauseDetect;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

}
