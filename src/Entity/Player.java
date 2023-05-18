package Entity;


import java.util.ArrayList;
import Weapon.BaseWeapon;
import Weapon.Gun;
import application.GamePlayPage;
import javafx.scene.paint.Color;

public class Player extends BaseEntity {
	private int currentexp=0;
	private int nextLv;
	private int Lv;
	private BaseWeapon weapon;
	private boolean ultiReady=true; //check player can use ultimate skill
	public final int SPEED=3;
	private boolean damage = false;
	
	public boolean isUltiReady() {
		return ultiReady;
	}

	public void setUltiReady(boolean ultiReady) {
		this.ultiReady = ultiReady;
	}

	public Player(int x, int y){
		super(x,y,50);
		this.setColor(Color.BLUE);
		this.setLv(1);
		this.setCurrentExp(0);
		this.setLv(1);
		this.setNextLv(100);
		this.weapon = new Gun();
	}
	
	public void takeDamage(int dmg){
		if (damage) return;
		this.setHp(this.getHp()-dmg);
		damage = true;
		GamePlayPage.coolDown(150, () -> damage = false);
	}
	public void iAmAtomic(ArrayList<Enemy> Enemys) {//ultimate skill
		if(this.isUltiReady()) {
			for(Enemy e : Enemys) {
				e.dropItem(GamePlayPage.items);
			}
			this.setUltiReady(false);
			GamePlayPage.coolDown(5000, () -> this.setUltiReady(true));//perform ultimate skill  with cooldown 5 sec (not balance)
			Enemys.clear();
		}
		else {
			return;
		}
		
	}
	public void move(int vx, int vy){
		if(GamePlayPage.background.getX()<=0 || GamePlayPage.background.getX()+GamePlayPage.background.getWidth()>800) {//X-axis
			if(GamePlayPage.background.getX()-vx>=0) {//left bound
				GamePlayPage.background.setX(0);
				this.setX(this.getX()+vx);
				}
			else if(GamePlayPage.background.getX()-vx+GamePlayPage.background.getWidth()<=800) {//right bound
				this.setX(this.getX()+vx);
				}
			else {
				if(this.getX()<400) {
					if(this.getX()+vx>400) {
						this.setX(400);
						}
					else {
						this.setX(this.getX()+vx);
						}
					}
				else if(this.getX()>400) {
					if(this.getX()+vx<400) {
						this.setX(400);
						}
					else {
						this.setX(this.getX()+vx);
						}
					}
				else {
					GamePlayPage.background.setX(GamePlayPage.background.getX()-vx);
					}
			}
			}
				
		if(GamePlayPage.background.getY()<=0 || GamePlayPage.background.getY()+GamePlayPage.background.getHeight()>600) {//Y-axis
			if(GamePlayPage.background.getY()-vy>=0) {//top bound
				GamePlayPage.background.setY(0);
				this.setY(this.getY()+vy);
				}
			else if(GamePlayPage.background.getY()-vy+GamePlayPage.background.getHeight()<=600) {//bottom bound
				this.setY(this.getY()+vy);
				}
			else {
				if(this.getY()<300) {
					if(this.getY()+vy>300) {
						this.setY(300);
						}
					else {
						this.setY(this.getY()+vy);
						}
					}
				else if(this.getY()>300) {
					if(this.getY()+vy<300) {
						this.setY(300);
						}
					else {
						this.setY(this.getY()+vy);
						}
					}
				else {
					GamePlayPage.background.setY(GamePlayPage.background.getY()-vy);
					}
				}
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
	public void setX(int x) {
		this.x=Math.max(25, Math.min(775, x));
	}
	public void setY(int y) {
		this.y = Math.max(25, Math.min(575, y));
	}
}
