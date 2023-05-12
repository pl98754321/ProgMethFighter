package Entity;


import java.util.ArrayList;
import Bullet.Bullet;
import Weapon.BaseWeapon;
import Weapon.Gun;
import application.MainApplication;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends BaseEntity {
	private int currentexp=0;
	private int nextLv;
	private int Lv;
	private BaseWeapon weapon;
	private boolean ultiReady=true;
	
	public boolean isUltiReady() {
		return ultiReady;
	}

	public void setUltiReady(boolean ultiReady) {
		this.ultiReady = ultiReady;
	}

	public final int SPEED=3;
	private boolean damage = false;
	
	public Player(int x, int y){
		super(x,y,50);
		this.setColor(Color.BLUE);
		this.setLv(1);
		this.setCurrentExp(0);
		this.Lv=1;
		this.nextLv=100;
		this.weapon = new Gun();
	}
	
	public void takeDamage(int dmg){
		if (damage) return;
		this.setHp(this.getHp()-dmg);
		damage = true;
		MainApplication.coolDown(150, () -> damage = false);
	}
	public void iAmAtomic(ArrayList<Enemy> Enemys) {//ultimate skill ("i am atomic" มาจากการ์ตูนเรื่องนึงครับ)
		if(this.isUltiReady()) {
			for(Enemy e : Enemys) {
				e.dropItem(MainApplication.items);
			}
			this.setUltiReady(false);
			MainApplication.coolDown(5000, () -> this.setUltiReady(true));
			Enemys.clear();
		}
		else {
			return;
		}
		
	}
	
	
	


	public void shoot(int x, int y){
		weapon.shoot(this.getX(), this.getY(), x, y);
	}
	
	//getter setter
	public int getNextLv() {
		return this.nextLv;
	}

	public void setNextLv(int nextLv) {
		this.nextLv = nextLv;
	}
	public int getCurrentExp() {
		return this.currentexp;
	}

	public void setCurrentExp(int exp) {
		this.currentexp = exp;
	}

	public int getLv() {
		return this.Lv;
	}

	public void setLv(int lv) {
		this.Lv = lv;
	}
}
