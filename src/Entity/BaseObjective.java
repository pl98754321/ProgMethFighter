package Entity;

import application.GamePlayPage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BaseObjective {
	protected int x;
	protected int y;
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
	
	public double distance(Player p) {
		double dis = Math.sqrt(Math.pow(GamePlayPage.background.getX()+x-p.x, 2)+Math.pow(GamePlayPage.background.getY()+y-p.y, 2));
		return dis-this.getSize()/2-p.getSize()/2;
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
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x=x;
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
