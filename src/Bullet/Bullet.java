package Bullet;

import Entity.BaseObjective;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends BaseObjective{
	private double direction;
	
	public Bullet(double direction, int x, int y){
		super(x,y,20);
		this.direction = direction;
	}
	
	public void update(GraphicsContext gc){
		this.render(gc, Color.BLACK);
		this.move((int) (Math.cos(this.direction)*10), 
				(int) (Math.sin(this.direction)*10));
	}
}
