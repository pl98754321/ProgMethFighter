package entity.bullet;

import entity.base.BaseBullet;
import entity.unit.Player;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class GunBullet extends BaseBullet{
	private double direction;
	
	public GunBullet(double x, double y,int size,int speed,int atk,double direction){
		super(-GamePlayPage.background.getX()+x, -GamePlayPage.background.getY()+y,size,speed,Color.BLACK,atk);
		this.direction = direction;
	}
	
	@Override
	public void move(Player player) {
		this.move((int) (Math.cos(this.direction)*this.getSpeed()), 
				(int) (Math.sin(this.direction)*this.getSpeed()));
	}
}
