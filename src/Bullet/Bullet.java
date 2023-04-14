package Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet{
	private int  x, y;
	private double direction;
	
	public Bullet(double direction, int x, int y){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public void update(GraphicsContext gc){
		gc.setFill(Color.BLACK);
		gc.fillOval(this.x, this.y,20 , 20);
		this.x += Math.cos(this.direction)*10;
		this.y += Math.sin(this.direction)*10;
	}
}
