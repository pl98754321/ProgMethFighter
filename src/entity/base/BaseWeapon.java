package entity.base;

public abstract class BaseWeapon {
	private int atk;
	private int speed;
	private int size;
	private int coolDown;

	public BaseWeapon(int size,int speed,int atk,int coolDown) {
		this.setSize(size);
		this.setSpeed(speed);
		this.setAtk(atk);
		this.setCoolDown(coolDown);
	}
	
	public abstract void shoot(double d, double e,double toX,double toY);
	
	//getter setter
	public int getAtk() {
		return atk;
	}

	public void setAtk(int attack) {
		this.atk = Math.max(0, attack);
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
