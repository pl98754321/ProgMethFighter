package Item;

import Entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Potion extends BaseItem {
	public final int HP=10;
	
	public Potion(int x, int y) {
		super(x,y,10);
	}
	
	@Override
	public void render(GraphicsContext gc){
		this.render(gc, Color.LIGHTBLUE);		
	}

	@Override
	public void performEffect(Player player) {
		player.setHp(player.getHp()+this.HP);
		}
		
}	
