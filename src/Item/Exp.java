package Item;

import Entity.Player;
import javafx.scene.paint.Color;

public class Exp extends BaseItem {
	public final int EXP=10;
	
	public Exp(int x, int y) {
		super(x,y,10);
		this.setColor(Color.YELLOW);
	}

	@Override
	public void performEffect(Player player) {
		player.setCurrentExp(player.getCurrentExp()+this.EXP);
		if(player.getCurrentExp()>=player.getNextLv()) {
			player.setLv(player.getLv()+1);
			player.setCurrentExp(player.getCurrentExp()-player.getNextLv());
			player.setNextLv((int)(player.getNextLv()*1.1));
		}
	}	
}
