package entity.weapon;

import entity.base.BaseBullet;
import entity.base.BaseWeapon;

public class Magic extends BaseWeapon {

	public Magic(int attack, int speed, int size, int coolDown) {
		super(attack, speed, size, coolDown);
		// TODO Auto-generated constructor stub
	}
	@Override
	public BaseBullet weaponBullet(double currentX, double currentY, double toX, double toY) {
		// TODO Auto-generated method stub
		return null;
	}
}
