package Item;

import Entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Potion extends BaseItem {
	public final int HP=10;
	
	public Potion(int x, int y) {
		super(x,y);
	}
	
	public void render(GraphicsContext gc){
		gc.setFill(Color.LIGHTBLUE);
		gc.fillOval(this.getX()+5, this.getY()+5, 10, 10);
		
	}

	@Override
	public void performEffect(Player player) {
		player.setHp(player.getHp()+this.HP);
		}
		
}	
