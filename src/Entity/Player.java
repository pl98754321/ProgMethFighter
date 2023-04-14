package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends BaseEntity {
	private int hp = 100;
	public static final int SPEED=3;
	
	public Player(int Hp,int x, int y){
		super(Hp,x,y);
	}
	
	public int getHp(){
		return this.hp;
	}
	public void render(GraphicsContext gc){
		gc.setFill(Color.RED);
		gc.fillOval(this.getX(), this.getY(), 50, 50);
	}
}
