package Item;

import Entity.BaseObjective;
import Entity.Player;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseItem extends BaseObjective{	
	public BaseItem(int x,int y,int size) {
		super(x,y,size);
	}
	public abstract void render(GraphicsContext gc);
	public abstract void performEffect(Player player);
}
