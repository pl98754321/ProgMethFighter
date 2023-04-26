package Entity;

import application.MainApplication;
import application.GamePlay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends BaseEntity{
	private int x, y;
	private Player player;

	
	public Enemy(Player p, int x, int y){
		super(x,y,40);
		this.player = p;
	}
	
	private boolean checkCollision(){
		for (int i = 0; i < GamePlay.enemies.size(); i++){
			Enemy e = GamePlay.enemies.get(i);
			if (e != this){
				if (e.collided(this.getX(), this.getY(), 40, 40)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean collided(double x, double y, double w1, double w2){
		return Math.sqrt(Math.pow(this.getX()+w1/2-x-w2/2, 2)+Math.pow(this.getY()+w1/2-y-w2/2, 2)) <= w1/2+w2/2;
	}
	
	public void render(GraphicsContext gc){
		this.render(gc, Color.BLACK);
		double distance = Math.sqrt(Math.pow(this.getX()-this.player.getX(), 2)+Math.pow(this.getY()-this.player.getY(), 2));
		if (distance <= 40){
			this.player.takeDamage(5);
//			GamePlay.enemies.remove(this);
			MainApplication.enemies.remove(this);
		} else {
			double angle = Math.atan2(this.player.getY()-this.getY(), this.player.getX()-this.getX());
			this.move((int) (Math.cos(angle)*2),0);
			if (checkCollision()){
				this.move(-(int) (Math.cos(angle)*2),0);
			}
			this.move(0,(int) (Math.sin(angle)*2));
			if (checkCollision()){
				this.move(0,-(int) (Math.sin(angle)*2));
			}
		}
	}
}
