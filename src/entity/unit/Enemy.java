package entity.unit;

import java.util.ArrayList;

import entity.base.BaseEntity;
import entity.base.BaseItem;
import entity.base.BaseObjective;
import entity.base.KnockBackAble;
import entity.item.Exp;
import entity.item.Magnet;
import entity.item.Potion;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class Enemy extends BaseEntity implements KnockBackAble{
	private Player player;

	
	public Enemy(Player p, int x, int y){
		super(x,y,40,2);
		this.setColor(Color.BLACK);
		this.setPlayer(p);
	}
	public Enemy(Player p, int x, int y, int size,int speed ,Color color){
		super(x,y,size,speed);
		this.setColor(color);
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
		super.move(others, -10);
		this.checkCollision();
	}
	
	public void move(Player player) {
		super.move(player);
		this.checkCollision();
	}
	public void dropItem(ArrayList<BaseItem> items) {
		if(Math.random()<=0.2) {
			items.add(new Potion(this.getX()-4,this.getY()));
		}
		if(Math.random()<=0.2) {
			items.add(new Magnet(this.getX()+4,this.getY()));			
		}
		items.add(new Exp(this.getX(),this.getY()));
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
		double dis = Math.sqrt(Math.pow(+x-others.getX(), 2)+Math.pow(+y-others.getY(), 2));
		return dis-this.getSize()/2-others.getSize()/2;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
