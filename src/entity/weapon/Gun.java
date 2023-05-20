package entity.weapon;

import entity.base.BaseWeapon;
import entity.bullet.GunBullet;
import javafx.scene.media.AudioClip;
import page.GamePlayPage;
public class Gun extends BaseWeapon {
	private boolean shooting = false;
	private AudioClip shoot = new AudioClip(ClassLoader.getSystemResource("audio/shoot.mp3").toString());
	public Gun(int size,int speed,int attack,int coolDown) {
		super(size,speed,attack,coolDown);
	}
	
	@Override
	public void shoot(double currentX, double currentY, double toX, double toY) {
		// TODO Auto-generated method stub
		if (!shooting) {
			shooting = true;
			GamePlayPage.coolDown(this.getCoolDown(), () -> this.shooting = false);
			double direction = Math.atan2(toY-currentY, toX-currentX);
			GunBullet b = new GunBullet(currentX+20, currentY+20,this.getSize(),this.getSpeed(),this.getAtk(),direction);
			shoot.play();
			GamePlayPage.bullets.add(b);
		}
	}
}
