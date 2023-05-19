package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BaseObjective {
	private int x,y;
	private int size;
	private Color color;
	
	public BaseObjective(int x ,int y,int size) {
		this.setX(x);
		this.setY(y);
		this.setSize(size);
	}
	
	public void move(int vx, int vy){
		this.setX(this.getX()+vx);
		this.setY(this.getY()+vy);
	}
	public void move(BaseObjective others,int speed){
		double angle = Math.atan2(others.getY()-this.getY(), others.getX()-this.getX());
		this.move((int) (Math.cos(angle)*speed),0);
		this.move(0,(int) (Math.sin(angle)*speed));
	}
	
	public double distance(BaseObjective others) {
		double dis = Math.sqrt(Math.pow(x-others.x, 2)+Math.pow(y-others.y, 2));
		return dis-this.getSize()/2-others.getSize()/2;
	} 
	
	public void render(GraphicsContext gc) {
		gc.setFill(this.getColor());
		gc.fillOval(this.getX()-size/2, this.getY()-size/2, size, size);
	}
	

	// Getter setter
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void setColor(Color c) {
		this.color=c;
	}
	public Color getColor() {
		return this.color;
	}
}
