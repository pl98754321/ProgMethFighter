package Weapon;

import Bullet.Bullet;
import application.MainApplication;

public class Gun extends BaseWeapon {
	private boolean shooting = false;
	public Gun() {
		super(10, 5);
	}
	
	@Override
	public void shoot(int currentX, int currentY, int toX, int toY) {
		// TODO Auto-generated method stub
		if (!shooting) {
			shooting = true;
			MainApplication.coolDown(200, () -> this.shooting = false);
			double direction = Math.atan2(toY-currentY, toX-currentX);
			Bullet b = new Bullet(direction, currentX+20, currentY+20);
			MainApplication.bullets.add(b);
		}
	}
}
