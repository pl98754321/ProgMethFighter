package Item;

import Entity.BaseObjective;
import Entity.Player;

public abstract class BaseItem extends BaseObjective{	
	Boolean isMagnet;
	public BaseItem(int x,int y,int size) {
		super(x,y,size);
		isMagnet = false;
	}
	public abstract void performEffect(Player player);
	
	public void move(BaseObjective others) {
		if (this.isMagnet) {
			this.move(others, 5);
		}
}
	public Boolean getisMagnet() {
		return this.isMagnet;
	}
	public void setisMagnet(boolean bool) {
		this.isMagnet = bool;
	}
	}
