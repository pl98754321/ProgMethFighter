package logic;

import java.util.ArrayList;
import java.util.Random;

import entity.base.BaseBullet;
import entity.base.BaseItem;
import entity.item.Exp;
import entity.item.Magnet;
import entity.item.Potion;
import entity.unit.Enemy;
import entity.unit.EnermySpeedter;
import entity.unit.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class GamePlayLogic {
	public static Thread getSpawner(Player player) {
		Thread spawner = new Thread(() -> {
			try {
				Random random = new Random();
				while (true){
					if (random.nextDouble()>=0.2) {
					GamePlayPage.enemies.add(
							new Enemy(player,
									(int) (GamePlayPage.background.getHeight()*random.nextDouble()),
									(int) (GamePlayPage.background.getWidth()*random.nextDouble())
									)
							);}
					else {
						GamePlayPage.enemies.add(
								new EnermySpeedter(player,
										(int) (GamePlayPage.background.getHeight()*random.nextDouble()),
										(int) (GamePlayPage.background.getWidth()*random.nextDouble())
										)
								);
					}
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
		for (BaseBullet a :bullets){
			a.move(player);
			a.render(gc);
		}
	}
	public static void updateItems(GraphicsContext gc,Player player,ArrayList<BaseItem> items) {
		for (int i = 0; i < items.size(); i++){
			BaseItem item = items.get(i);
			item.move(player);
			item.render(gc);
			if(item.distance(player)<=0){
				item.performEffect(player);
				GamePlayPage.items.remove(item);
			}
		}
	}
	public static void updateEnemy(GraphicsContext gc,Player player,ArrayList<Enemy> enemies,ArrayList<BaseBullet> bullets,ArrayList<BaseItem> items) {
	AudioClip explosion = new AudioClip(ClassLoader.getSystemResource("audio/Explosion.wav").toString());
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
	}
}
