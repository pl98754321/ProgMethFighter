package Item;

import Entity.Player;
import application.MainApplication;
import javafx.scene.paint.Color;

public class Potion extends BaseItem {
	public final int HP=10;
	
	public Potion(int x, int y) {
		super(x,y,10);
		this.setColor(Color.LIGHTBLUE);
	}

	@Override
	public void performEffect(Player player) {
		player.setHp(player.getHp()+this.HP);
		MainApplication.items.remove(this);
	}
		
		
}	
