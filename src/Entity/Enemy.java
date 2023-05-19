package Entity;

import java.util.ArrayList;

import Item.BaseItem;
import Item.Exp;
import Item.Magnet;
import Item.Potion;
import application.GamePlayPage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends BaseEntity implements KnockBackAble{
	private Player player;

	
	public Enemy(Player p, int x, int y){
		super(x,y,40);
		this.setColor(Color.BLACK);
		this.player = p;
	}
	
	private boolean checkCollision(){
		for (int i = 0; i < GamePlayPage.enemies.size(); i++){
			Enemy e = GamePlayPage.enemies.get(i);
			if (e != this){
				if (this.distance(e) <=0){
					e.KnockBack(this);
					this.KnockBack(e);
					return true;
				}
			}
		}
		return false;
	}
	public void KnockBack(Enemy others) {
		this.move(others, -10);
		this.checkCollision();
	}
	
	public void move(BaseObjective others) {
		this.move(others, 2);
		this.checkCollision();
	}
	public void dropItem(ArrayList<BaseItem> items) {
		if(Math.random()<=0.2) {
			items.add(new Potion(this.getX()-5,this.getY()));
		}
		if(Math.random()<=0.2) {
			items.add(new Magnet(this.getX()+5,this.getY()));			
		}
		items.add(new Exp(this.getX(),this.getY()));
	}
	
	public void render(GraphicsContext gc){
		super.render(gc);
		if (this.distance(player) <= 0){
			this.player.takeDamage(5);
			GamePlayPage.enemies.remove(this);
		} else {
			this.move(this.player);
		}
	}
}
