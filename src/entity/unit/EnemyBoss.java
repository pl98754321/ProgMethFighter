package entity.unit;

import javafx.scene.paint.Color;
import page.GamePlayPage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemyBoss extends Enemy{
	private Image boss= new Image(ClassLoader.getSystemResource("bossPic.png").toString());
	
	public EnemyBoss(Player p, int x, int y) {
		super(p, x, y,100,3,1000,5,Color.LIGHTGREEN);
		this.setInvincibleTime(150);
	}
	
	@Override
	public void render(GraphicsContext gc){
		gc.drawImage(boss, GamePlayPage.background.getX()+this.getX()-getSize()/2,GamePlayPage.background.getY()+ this.getY()-getSize()/2,100,141.43);
	}
}
