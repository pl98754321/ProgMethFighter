package entity.base;

public abstract class BaseWeapon {
	private int attack;
	private int speed;
	private int size;
	private int coolDown;

	public BaseWeapon(int attack,int speed,int size,int coolDown) {
		this.setAttack(attack);
		this.setSpeed(speed);
		this.setSize(size);
		this.setCoolDown(coolDown);
	}
	
	public abstract void shoot(double d, double e,double toX,double toY);
	
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
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCoolDown() {
		return coolDown;
	}

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}
}
