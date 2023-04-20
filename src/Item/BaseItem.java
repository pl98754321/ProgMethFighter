package Item;

import Entity.Player;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseItem {
	private int x;
	private int y;
	
	public BaseItem(int x,int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public boolean collided(double x, double y, double w1, double w2){
		return Math.sqrt(Math.pow(this.getX()+w1/2-x-w2/2, 2)+Math.pow(this.getY()+w1/2-y-w2/2, 2)) <= w1/2+w2/2;
	}
	public abstract void render(GraphicsContext gc);
	public abstract void performEffect(Player player);
	
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
