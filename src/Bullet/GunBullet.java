package Bullet;

import Entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GunBullet extends BaseBullet{
	private double direction;
	
	public GunBullet(int x, int y,int size,int speed,double direction){
		super(x, y,size,speed);
		this.setColor(Color.BLACK);
		this.direction = direction;
	}
	
	@Override
	public void move(Player player) {
		this.move((int) (Math.cos(this.direction)*this.getSpeed()), 
				(int) (Math.sin(this.direction)*this.getSpeed()));
	}
}
