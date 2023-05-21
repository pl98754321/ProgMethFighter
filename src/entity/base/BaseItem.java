package entity.base;

import entity.unit.Player;
import javafx.scene.paint.Color;

public class BaseItem extends BaseObject{	
	private boolean isMagnet;
	public BaseItem(double x,double y,int size,Color color) {
		super(x,y,size,10,color);
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
