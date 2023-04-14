package Entity;

import java.util.ArrayList;

public abstract class BaseEntity {
	private int Hp;
	private int speed;
	private int x,y;
	
	public BaseEntity(int Hp,int x,int y) {
		this.setHp(Hp);
		this.setX(x);
		this.setY(y);
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public int getHp() {
		return this.Hp;
	}
	public void setHp(int hp) {
		this.Hp = Math.max(0, hp);
		if(this.Hp==0) {
			System.out.println("you not win");
		}
	}
	public void move(int vx, int vy){
		this.setX(this.getX()+vx);
		this.setY(this.getY()+vy);
	}
}
