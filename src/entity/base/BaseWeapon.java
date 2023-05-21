package entity.base;

import javafx.scene.media.AudioClip;
import logic.Utility;
import page.GamePlayPage;

public abstract class BaseWeapon {
	private int atk;
	private int speed;
	private int size;
	private int coolDown;
	private boolean shooting = false;
	private AudioClip shoot = new AudioClip(ClassLoader.getSystemResource("audio/shoot.mp3").toString());

	public BaseWeapon(int size,int speed,int atk,int coolDown) {
		this.setSize(size);
		this.setSpeed(speed);
		this.setAtk(atk);
		this.setCoolDown(coolDown);
	}
	
	public abstract BaseBullet weaponBullet(double currentX, double currentY,double toX,double toY);
	
	public void shoot(double currentX, double currentY, double toX, double toY) {
		// TODO Auto-generated method stub
		if (!shooting) {
			shooting = true;
			Utility.coolDown(this.getCoolDown(), () -> this.shooting = false);
			BaseBullet b = weaponBullet(currentX,currentY,toX,toY);
			shoot.play();
			GamePlayPage.bullets.add(b);
		}
	}
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
