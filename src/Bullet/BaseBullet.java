package Bullet;

import Entity.BaseObjective;
import Entity.Player;

public abstract class BaseBullet extends BaseObjective{
	public BaseBullet(double d, double e,int size,int speed){
		super(d, e,size,speed);}
	

	public abstract void move(Player player);
}
