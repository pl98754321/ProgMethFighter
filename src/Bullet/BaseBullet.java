package Bullet;

import Entity.BaseObjective;
import Entity.Player;

public abstract class BaseBullet extends BaseObjective{
	public BaseBullet(int x, int y,int size,int speed){
		super(x, y,size,speed);}
	
	public abstract void move(Player player);
}
