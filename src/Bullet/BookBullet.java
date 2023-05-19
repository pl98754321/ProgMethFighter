package Bullet;

import Entity.BaseObjective;
import Entity.Player;
import application.GamePlayPage;

public class BookBullet extends BaseBullet{
	public BookBullet(double x, double y, int size, int speed,int r) {
		super(-GamePlayPage.background.getX()+x, -GamePlayPage.background.getY()+y, size, speed);
	}

	@Override
	public void move(Player player) {
		// TODO Auto-generated method stub
//		double acc = Math.atan2(this.x-player.getX(),this.y-player.getY());
		double direction = Math.atan2(this.y-player.getY()+GamePlayPage.background.getY(), 
				this.x-player.getX()+GamePlayPage.background.getX());
		this.move(-Math.sin(direction)*2, 
				Math.cos(direction)*2);
	}

}
