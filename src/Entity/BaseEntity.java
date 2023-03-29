package Entity;

import java.util.ArrayList;

public abstract class BaseEntity {
	private int Hp;
	private int speed;
	private ArrayList<Integer> position;
	
	public BaseEntity(int Hp,int speed,ArrayList<Integer> position) {
		this.setHp(Hp);
		this.setSpeed(speed);
		this.setPosition(position);
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHp() {
		return this.Hp;
	}
	public void setHp(int hp) {
		this.Hp = Math.max(0, hp);
	}
	public ArrayList<Integer> getPosition() {
		return position;
	}
	public void setPosition(ArrayList<Integer> position) {
		this.position = position;
	}
}
