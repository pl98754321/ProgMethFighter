package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Exp {
	public int exp=10;
	private int x;
	private int y;
	public Exp(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void render(GraphicsContext gc,double x,double y){
		gc.setFill(Color.YELLOW);
		gc.fillOval(x, y, 10, 10);
		
	}
//	private boolean checkCollision(){
//		for (int i = 0; i < GamePlay.exps.size(); i++){
//			Exp e = GamePlay.exps.get(i);
//			if (e != this){
//				if (e.collided(this.x, this.y, 5, 5)){
//					System.out.println("trueeeeeeeeeeee---");
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	public boolean collided(double x, double y, double w1, double w2){
		// Check if the distance between the center of the the 2 enemies is less than the total width (diameter)
		return Math.sqrt(Math.pow(this.x+w1/2-x-w2/2, 2)+Math.pow(this.y+w1/2-y-w2/2, 2)) <= w1/2+w2/2;
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
