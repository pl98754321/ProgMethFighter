package entity.bullet;

import javafx.scene.paint.Color;
import entity.base.BaseBullet;
import entity.unit.Player;
import page.GamePlayPage;

public class BookBullet extends BaseBullet{
	public BookBullet(double x, double y, int size, int speed,int attack) {
		super(-GamePlayPage.background.getX()+x, -GamePlayPage.background.getY()+y, size, speed,Color.BLACK,attack);
	}

	@Override
	public void move(Player player) {
		double direction = Math.atan2(this.getY()-player.getY()+GamePlayPage.background.getY(), 
				this.getX()-player.getX()+GamePlayPage.background.getX());
		this.move(-Math.sin(direction)*this.getSpeed(), Math.cos(direction)*this.getSpeed());
	}
	public static void followXPlayer(int vx) {
		for(int i =0 ;i<GamePlayPage.bullets.size();i++) {
			BaseBullet b= GamePlayPage.bullets.get(i);
			if(b instanceof BookBullet) {
				b.setX(b.getX()+vx);
			}
		}
	}
	public static void followYPlayer(int vy) {
		for(int i =0 ;i<GamePlayPage.bullets.size();i++) {
			BaseBullet b= GamePlayPage.bullets.get(i);
			if(b instanceof BookBullet) {
				b.setY(b.getY()+vy);
			}
		}
	}
}
