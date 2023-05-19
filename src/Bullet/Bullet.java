package Bullet;

import Entity.BaseObjective;
import application.GamePlayPage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends BaseObjective{
	private double direction;
	
	public Bullet(double direction, int x, int y,int size,int speed){
		super(-GamePlayPage.background.getX()+x,-GamePlayPage.background.getY()+y,size,speed);
		this.setColor(Color.BLACK);
		this.direction = direction;
	}
	
	public void render(GraphicsContext gc){
		super.render(gc);
		this.move((int) (Math.cos(this.direction)*this.getSpeed()), 
				(int) (Math.sin(this.direction)*this.getSpeed()));
	}
}
