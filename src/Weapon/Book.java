package Weapon;

import Bullet.BookBullet;
import application.GamePlayPage;
import javafx.scene.media.AudioClip;
public class Book extends BaseWeapon {
	private boolean shooting = false;
	private AudioClip shoot = new AudioClip(ClassLoader.getSystemResource("audio/shoot.mp3").toString());
	public Book() {
		super(10, 20,10,200);
	}
	public Book(int attack,int speed,int size,int coolDown) {
		super(attack,attack,size,coolDown);
	}
	
	@Override
	public void shoot(double currentX, double currentY, double toX, double toY) {
		// TODO Auto-generated method stub
		if (!shooting) {
			shooting = true;
			GamePlayPage.coolDown(this.getCoolDown(), () -> this.shooting = false);
			BookBullet b = new BookBullet(currentX, currentY-100,this.getSize(),this.getSpeed(),50);
			shoot.play();
			GamePlayPage.bullets.add(b);
		}
	}
}
