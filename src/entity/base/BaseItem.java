package entity.base;

import entity.unit.Player;

public abstract class BaseItem extends BaseObjective{	
	boolean Ismagnet;
	public BaseItem(double x,double y,int size) {
		super(x,y,size,10);
		this.Ismagnet = false;
	}
	public abstract void performEffect(Player player);
	
	public void move(Player player) {
		if (isIsmagnet()) {super.move(player);}
	}
	public boolean isIsmagnet() {
		return Ismagnet;
	}
	public void setIsmagnet(boolean ismagnet) {
		Ismagnet = ismagnet;
	}
}
