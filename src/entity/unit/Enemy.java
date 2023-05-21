package entity.unit;

import java.util.ArrayList;

import entity.base.BaseEntity;
import entity.base.BaseItem;
import entity.item.Exp;
import entity.item.Magnet;
import entity.item.Potion;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class Enemy extends BaseEntity{
	private Player player;
	private AudioClip explosion = new AudioClip(ClassLoader.getSystemResource("audio/Explosion.wav").toString());


	public Enemy(Player p, int x, int y, int size,int speed ,Color color,int hp,int atk){
		super(x,y,size,speed,color,hp,atk);
		this.setPlayer(p);
	}
	
	private boolean checkCollision(){
		for (int i = 0; i < GamePlayPage.enemies.size(); i++){
			Enemy e = GamePlayPage.enemies.get(i);
			if (e != this){
				if (this.distance(e) <=0){
					e.knockBack(this);
					this.knockBack(e);
					return true;
				}
			}
		}
		return false;
	}
	public void knockBack(BaseEntity others) {
		super.move(others, -10);
		this.checkCollision();
	}
	
	public void move(Player player) {
		super.move(player);
		this.checkCollision();
	}
	
	@Override
	public void died() {
		GamePlayPage.enemies.remove(this);
		this.dropItem(GamePlayPage.items);
		this.explosion.play();
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
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
