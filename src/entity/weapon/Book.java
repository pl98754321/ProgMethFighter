package entity.weapon;

import entity.base.BaseBullet;
import entity.base.BaseWeapon;
import entity.bullet.BookBullet;

public class Book extends BaseWeapon {
	public Book() {
		super(10, 3,10,200);
	}
	public Book(int attack,int speed,int size,int coolDown) {
		super(attack,speed,size,coolDown);
	}
	
	@Override
	public BaseBullet weaponBullet(double currentX, double currentY, double toX, double toY) {
		return new BookBullet(currentX, currentY-100,this.getSize(),this.getSpeed(),this.getAtk());
	}
}
