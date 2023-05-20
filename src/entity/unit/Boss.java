package entity.unit;

import javafx.scene.paint.Color;
import page.GamePlayPage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends Enemy{
	private boolean damage = false;
	private Image boss= new Image(ClassLoader.getSystemResource("bossPic.png").toString());
	
	public Boss(Player p, int x, int y) {
		super(p, x, y);
		this.setSize(100);
		this.setMaxHP(1000);
		this.setColor(Color.LIGHTGREEN);
		this.setHp(1000);
	}
	
	public void takeDamage(int dmg){
		if (damage) return;
		this.setHp(this.getHp()-dmg);
		damage = true;
		GamePlayPage.coolDown(150, () -> damage = false);
	}
	public void draw(GraphicsContext gc){
		gc.drawImage(boss, GamePlayPage.background.getX()+x-getSize()/2,GamePlayPage.background.getY()+ y-getSize()/2,100,141.43);
	}
}
