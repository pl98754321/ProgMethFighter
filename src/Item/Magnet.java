package Item;

import Entity.Player;
import application.GamePlayPage;
import javafx.scene.paint.Color;

public class Magnet extends BaseItem {
	public Magnet(int x, int y) {
		super(x,y,10);
		this.setColor(Color.RED);
	}

	@Override
	public void performEffect(Player player) {//let all item on the screen perform!!!
		for(int i=0;i<GamePlayPage.items.size();i++) {
			BaseItem item =GamePlayPage.items.get(i);
			if(!(item instanceof Magnet)) {//if(it is  Magnet ){recursive ?!?!?}
				item.performEffect(player);
				}
			}
		GamePlayPage.items.clear();
	}
}
