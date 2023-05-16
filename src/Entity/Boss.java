package Entity;

import application.GamePlayPage;
import javafx.scene.paint.Color;

public class Boss extends Enemy{
	private boolean damage = false;
	
	public Boss(Player p, int x, int y) {
		super(p, x, y);
		this.setSize(60);
		this.setColor(Color.LIGHTGREEN);
		this.setHp(10);
	}
	
	public void takeDamage(int dmg){
		if (damage) return;
		this.setHp(this.getHp()-dmg);
		damage = true;
		GamePlayPage.coolDown(150, () -> damage = false);
	}
}
