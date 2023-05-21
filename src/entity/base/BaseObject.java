package entity.base;

import entity.unit.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class BaseObject {
	private double x;
	private double y;
	private int size;
	private int speed;
	private Color color;
	
	public BaseObject(double d ,double e,int size,int speed, Color color) {
		this.setX(d);
		this.setY(e);
		this.setSize(size);
		this.setSpeed(speed);
		this.setColor(color);
	}
	public void move(double vx, double vy){
		this.setX(this.getX()+vx);
		this.setY(this.getY()+vy);
	}
	public void move(int vx, int vy){
		this.move((double) (vx),(double) (vy));
	}

	public void move(Player player) {
		double angle = Math.atan2(-GamePlayPage.background.getY()+player.getY()-this.getY(),-GamePlayPage.background.getX()+player.getX()-this.getX());
		this.move((int) (Math.cos(angle)*this.speed),(int) (Math.sin(angle)*this.speed));
	}
	public void move(BaseObject others,int speed) {
		double angle = Math.atan2(others.getY()-this.getY(), others.getX()-this.getX());
		this.move((int) (Math.cos(angle)*speed),(int) (Math.sin(angle)*speed));
	}
	
	public double distance(Player p) {
		double dis = Math.sqrt(Math.pow(GamePlayPage.background.getX()+x-p.getX(), 2)+Math.pow(GamePlayPage.background.getY()+y-p.getY(), 2));
		return dis-this.getSize()/2-p.getSize()/2;
	}
	public double distance(BaseObject others) {
		double dis = Math.sqrt(Math.pow(this.getX()-others.getX(), 2)+Math.pow(this.getY()-others.getY(), 2));
		return dis-this.getSize()/2-others.getSize()/2;
	}
	
	public void render(GraphicsContext gc) {
		gc.setFill(this.getColor());
		gc.fillOval(GamePlayPage.background.getX()+this.getX()-size/2,GamePlayPage.background.getY()+ this.getY()-size/2, size, size);
	}
	// Getter setter
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x=x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public void setColor(Color c) {
		this.color=c;
	}
	public Color getColor() {
		return this.color;
	}
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
