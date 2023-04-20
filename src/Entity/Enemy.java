package Entity;

import application.FirstPage;
import application.GamePlay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy{
	private int x, y;
	private Player player;

	
	public Enemy(Player p, int x, int y){
		this.player = p;
		this.x = x;
		this.y = y;
	}
	
	private boolean checkCollision(){
		for (int i = 0; i < GamePlay.enemies.size(); i++){
			Enemy e = GamePlay.enemies.get(i);
			if (e != this){
				if (e.collided(this.x, this.y, 40, 40)){
					return true;
				}
			}
		}
		return false;
	}
	


	public boolean collided(double x, double y, double w1, double w2){
		return Math.sqrt(Math.pow(this.x+w1/2-x-w2/2, 2)+Math.pow(this.y+w1/2-y-w2/2, 2)) <= w1/2+w2/2;
	}
	
	public void render(GraphicsContext gc){
		gc.setFill(Color.RED);
		gc.fillOval(this.x, this.y, 40, 40);
		double distance = Math.sqrt(Math.pow(this.x-this.player.getX(), 2)+Math.pow(this.y-this.player.getY(), 2));
		if (distance <= 40){
			this.player.takeDamage(5);
//			GamePlay.enemies.remove(this);
			FirstPage.enemies.remove(this);
		} else {
			double angle = Math.atan2(this.player.getY()-this.y, this.player.getX()-this.x);
			this.x += Math.cos(angle)*2;
			if (checkCollision()){
				this.x -= Math.cos(angle)*2;
			}
			this.y += Math.sin(angle)*2;
			if (checkCollision()){
				this.y -= Math.sin(angle)*2;
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
