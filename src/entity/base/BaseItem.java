package entity.base;

import entity.unit.Player;

public class BaseItem extends BaseObject{	
	private boolean isMagnet;
	public BaseItem(double x,double y,int size) {
		super(x,y,size,10);
		this.isMagnet = false;
	}
	
	public void move(Player player) {
		if (isMagnet()) {super.move(player);}
	}
	public boolean isMagnet() {
		return isMagnet;
	}
	public void setisMagnet(boolean isMagnet) {
		this.isMagnet = isMagnet;
	}
}
