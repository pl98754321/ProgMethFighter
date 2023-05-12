package Item;

import Entity.Player;
import application.MainApplication;
import javafx.scene.paint.Color;

public class Magnet extends BaseItem {

	public Magnet(int x, int y) {
		super(x,y,10);
		this.setColor(Color.RED);
	}

	@Override
	public void performEffect(Player player) {//let all item on the screen perform!!!
		new Thread(() -> {
			for(BaseItem item:MainApplication.items) {
				
				if(!(item instanceof Magnet)) {//if(it is  Magnet ){recursive ?!?!?}
					item.performEffect(player);
					System.out.println(item.toString());
				}
			}
			MainApplication.items.clear();
		}).start();
		
		
	}
}
