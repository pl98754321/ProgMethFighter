package entity.weapon;

import entity.base.BaseBullet;
import entity.base.BaseWeapon;
import entity.bullet.GunBullet;

public class Gun extends BaseWeapon {
	public Gun(int size,int speed,int attack,int coolDown) {
		super(size,speed,attack,coolDown);
	}

	@Override
	public BaseBullet weaponBullet(double currentX, double currentY, double toX, double toY) {
		// TODO Auto-generated method stub
		double direction = Math.atan2(toY-currentY, toX-currentX);
		return new GunBullet(currentX+20, currentY+20,this.getSize(),this.getSpeed(),this.getAtk(),direction);
	}
}
