package Weapon;

public abstract class BaseWeapon {
	private int attack;
	private int speed;
	
	public BaseWeapon(int attack,int speed) {
		this.setAttack(attack);
		this.setSpeed(speed);
	}
	
	//getter setter
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = Math.max(0, attack);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = Math.max(0, speed);
	}
}
