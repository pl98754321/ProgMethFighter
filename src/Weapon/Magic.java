package Weapon;

import Bullet.Bullet;
import application.GamePlayPage;
import javafx.scene.media.AudioClip;

public class Magic extends BaseWeapon {
	private boolean shooting = false;
	private AudioClip shoot = new AudioClip(ClassLoader.getSystemResource("audio/shoot.mp3").toString());
	public Magic() {
		super(10, 5);
	}

	@Override
	public void shoot(int currentX, int currentY, int toX, int toY) {
		if (!shooting) {
			shooting = true;
			GamePlayPage.coolDown(200, () -> this.shooting = false);
			double direction = Math.atan2(toY-currentY, toX-currentX);
			Bullet b = new Bullet(direction, currentX+20, currentY+20,100,3);
			shoot.play();
			GamePlayPage.bullets.add(b);
		}
	}
}
