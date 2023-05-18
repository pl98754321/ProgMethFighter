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
		this.setPlayer(p);
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
		double angle = Math.atan2(others.getY()-this.getY(), others.getX()-this.getX());
		this.move(-(int) (Math.cos(angle)*10),-(int) (Math.sin(angle)*10));
		this.checkCollision();
	}
	
	public void move(BaseObjective others) {
		double angle = Math.atan2(-GamePlayPage.background.getY()+others.getY()-this.getY(),-GamePlayPage.background.getX()+others.getX()-this.getX());
		this.move((int) (Math.cos(angle)*2),(int) (Math.sin(angle)*2));
		this.checkCollision();

	}
	public void dropItem(ArrayList<BaseItem> items) {
		if(Math.random()<=0.2) {
			items.add(new Potion(this.getX()-2,this.getY()));
		}
		if(Math.random()<=0.2) {
			items.add(new Magnet(this.getX()+4,this.getY()));			
		}
		items.add(new Exp(this.getX(),this.getY()));
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void render(GraphicsContext gc){
		if(this instanceof Boss) {
			((Boss) this).draw(gc);
		}
		else {
			super.render(gc);
		}
		if (this.distance(player) <= 0){
			this.player.takeDamage(5);
			GamePlayPage.enemies.remove(this);
		} else {
			this.move(this.player);
		}
	}
	public double distance(BaseObjective others) {
		double dis = Math.sqrt(Math.pow(+x-others.x, 2)+Math.pow(+y-others.y, 2));
		return dis-this.getSize()/2-others.getSize()/2;
	}
}
