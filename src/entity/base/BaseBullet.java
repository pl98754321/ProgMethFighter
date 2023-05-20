package entity.base;

import entity.unit.Player;
import page.GamePlayPage;

public abstract class BaseBullet extends BaseEntity{
	public BaseBullet(double d, double e,int size,int speed,int atk){
		super(d, e,size,speed,atk,atk);
	}
	@Override
	public void died() {
		GamePlayPage.bullets.remove(this);
	}
	public abstract void move(Player player);
}
