package Item;

import Entity.Player;
import javafx.scene.paint.Color;

public class Magnet extends BaseItem {

	public Magnet(int x, int y) {
		super(x,y,10);
		this.setColor(Color.RED);
	}

	@Override
	public void performEffect(Player player) {
		System.out.println("proform all item");
	}
}
