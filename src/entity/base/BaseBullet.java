package entity.base;

import entity.unit.Player;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public abstract class BaseBullet extends BaseEntity{
	public BaseBullet(double d, double e,int size,int speed,Color black,int atk){
		super(d, e,size,speed,black,atk,atk);
	}
	@Override
	public void died() {
		GamePlayPage.bullets.remove(this);
	}
	public abstract void move(Player player);
}
