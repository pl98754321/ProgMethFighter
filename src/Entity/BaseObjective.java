package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BaseObjective {
	private int x,y;
	private int size;
	
	public BaseObjective(int x ,int y,int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void move(int vx, int vy){
		int nextX=this.getX()+vx;
		int nextY=this.getY()+vy;
		this.setX(nextX);
		this.setY(nextY);
	}
	
	public double distance(BaseObjective others) {
		double dis = Math.sqrt(Math.pow(x-others.x, 2)+Math.pow(y-others.y, 2)
				);
		return dis-this.getSize()/2-others.getSize()/2;
	} 
	
	public void render(GraphicsContext gc,Color color) {
		gc.setFill(color);
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
}
