package Entity;

import application.MainApplication;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends BaseEntity{
	private Player player;

	
	public Enemy(Player p, int x, int y){
		super(x,y,40);
		this.player = p;
	}
	
	private boolean checkCollision(){
		for (int i = 0; i < MainApplication.enemies.size(); i++){
			Enemy e = MainApplication.enemies.get(i);
			if (e != this){
				if (this.distance(e) <=0){
					e.knockback(this);
					this.knockback(e);
					return true;
				}
			}
		}
		return false;
	}
	public void knockback(BaseObjective others) {
		double angle = Math.atan2(others.getY()-this.getY(), others.getX()-this.getX());
		this.move(-(int) (Math.cos(angle)*10),-(int) (Math.sin(angle)*10));
		this.checkCollision();
	}
	
	public void move(BaseObjective others) {
		double angle = Math.atan2(others.getY()-this.getY(), others.getX()-this.getX());
		this.move((int) (Math.cos(angle)*2),0);
//		if (checkCollision()){
//			this.move(-(int) (Math.cos(angle)*2),0);
//		}
		this.move(0,(int) (Math.sin(angle)*2));
		this.checkCollision();
//		if (checkCollision()){
//			this.move(0,-(int) (Math.sin(angle)*2));
//		}
	}
	
	public void render(GraphicsContext gc){
		this.render(gc, Color.BLACK);
		if (this.distance(player) <= 0){
			this.player.takeDamage(5);
//			GamePlay.enemies.remove(this);
			MainApplication.enemies.remove(this);
		} else {
			this.move(this.player);
		}
	}
}
