package Item;

import Entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Exp extends BaseItem {
	public final int EXP=10;
	
	public Exp(int x, int y) {
		super(x,y);
	}
	
	public void render(GraphicsContext gc){
		gc.setFill(Color.YELLOW);
		gc.fillOval(this.getX(), this.getY(), 10, 10);
		
	}

	@Override
	public void performEffect(Player player) {
		player.setCurrentExp(player.getCurrentExp()+this.EXP);
		if(player.getCurrentExp()>=player.getNextLv()) {
			player.setLv(player.getLv()+1);
			player.setCurrentExp(player.getCurrentexp()-player.getNextLv());
			player.setNextLv((int)(player.getNextLv()*1.1));
		}
	}	
}
