package logic;

import java.util.ArrayList;
import java.util.Random;

import entity.base.BaseBullet;
import entity.base.BaseItem;
import entity.base.EffectPlayer;
import entity.unit.Enemy;
import entity.unit.EnemyBoss;
import entity.unit.EnermyBalance;
import entity.unit.EnermySpeedter;
import entity.unit.EnermyTanker;
import entity.unit.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class GamePlayLogic {
	public static Thread getSpawner(Player player) {
		Thread spawner = new Thread(() -> {
			try {
				Random random = new Random();
				while (true){
					if (random.nextDouble()>=0.4) {
					GamePlayPage.enemies.add(
							new EnermyBalance(player,
									(int) (GamePlayPage.background.getHeight()*random.nextDouble()),
									(int) (GamePlayPage.background.getWidth()*random.nextDouble())
									)
							);}
					else if (random.nextDouble()>=0.2) {
					GamePlayPage.enemies.add(
							new EnermySpeedter(player,
									(int) (GamePlayPage.background.getHeight()*random.nextDouble()),
									(int) (GamePlayPage.background.getWidth()*random.nextDouble())
									)
							);}
					else {
						GamePlayPage.enemies.add(
								new EnermyTanker(player,
										(int) (GamePlayPage.background.getHeight()*random.nextDouble()),
										(int) (GamePlayPage.background.getWidth()*random.nextDouble())
										)
								);}
					Thread.sleep(300);
					if(player.getHp()<=0) {
						Thread.currentThread().interrupt();
						return;
					}
				}
			} catch (InterruptedException ex){
			}
		});
		return spawner;
	}
	
	
	public static void updateBullet(GraphicsContext gc,Player player,ArrayList<BaseBullet> bullets) {
		for (BaseBullet bullet :bullets){
			bullet.move(player);
			bullet.render(gc);
		}
	}
	public static void updateItems(GraphicsContext gc,Player player,ArrayList<BaseItem> items) {
		for (int i = 0; i < items.size(); i++){
			BaseItem item = items.get(i);
			item.move(player);
			item.render(gc);
			if(item.distance(player)<=0){
				if (item instanceof EffectPlayer ) {
					((EffectPlayer) item).performEffect(player);
				}
				GamePlayPage.items.remove(item);
			}
		}
	}
	public static void updateEnemy(GraphicsContext gc,Player player,ArrayList<Enemy> enemies,ArrayList<BaseBullet> bullets,ArrayList<BaseItem> items) {
		for (int i = 0; i < enemies.size(); i++){
			Enemy enermy = enemies.get(i);
			enermy.move(player);
			enermy.render(gc);
			for (int j = 0; j < bullets.size(); j++){
				BaseBullet bullet = bullets.get(j);
				if (enermy.distance(bullet)<=0){
					bullet.attack(enermy);
					enermy.attack(bullet);
					break;
				}
			}
			if (enermy.distance(player) <= 0){
				enermy.attack(player);
				player.attack(enermy);
			}
		}
	}
	public static void updateBoss(GraphicsContext gc,Player player,ArrayList<Enemy> enemies,EnemyBoss boss) {
		if(player.getLv()>=15) {
			if (!enemies.contains(boss)) {
				enemies.add(boss);
			}
//			boss.render(gc);
			gc.setFill(Color.RED);
			gc.fillRect(520, 20, (boss.getHp()*250/boss.getMaxHP()), 30);
			gc.setStroke(Color.BLACK);
			gc.strokeRect(520, 20, 250, 30);
		}
	}
	public static void updateHp(GraphicsContext gc,Player player) {
		int hp = player.getHp();
		int maxHp = player.getMaxHP();
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
		gc.fillRect(30, 20, hp * 250/maxHp , 30);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(30, 20, 250, 30);
		
		gc.setFill(Color.BLACK);
		gc.fillText("HP : " + hp + " / " + maxHp , 290 , 50);
	}
	
	public static void updateExp(GraphicsContext gc,Player player) {	//EXP
	gc.setFill(Color.LIGHTBLUE);
	gc.fillRect(30, 50, GamePlayPage.player.getCurrentExp()*200/player.getNextLv(), 10);
	gc.setStroke(Color.BLACK);
	gc.strokeRect(30, 50, 200, 10);
	
	gc.setFill(Color.BLACK);
	gc.fillText("Lv : "+player.getLv()+" EXP : "+player.getCurrentExp()+"/"+player.getNextLv(),240 ,60);}
}
