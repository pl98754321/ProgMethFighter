package entity.unit;


import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import entity.base.BaseEntity;
import entity.base.BaseObject;
import entity.base.BaseSkill;
import entity.base.BaseWeapon;
import entity.base.EffectWeapon;
import entity.bullet.BookBullet;
import entity.skill.SpeedUp;
import entity.weapon.Book;
import entity.weapon.Gun;
import entity.weapon.GunDagger;
import entity.weapon.GunNormal;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import page.GamePlayPage;
import javafx.scene.media.AudioClip;

public class Player extends BaseEntity {
	private int currentexp=0;
	private int nextLv;
	private int Lv;
	private AudioClip hit  =new AudioClip(ClassLoader.getSystemResource("audio/PlayerHit.mp3").toString());
	private ArrayList<EffectWeapon> skillsWeapon = new ArrayList<EffectWeapon>(); 
	private BaseWeapon weapon;
	private boolean ultiReady=true; //check player can use ultimate skill

	public Player(int x, int y){
		super(x,y,50,3,100,10);
		this.setColor(Color.BLUE);
		this.setLv(1);
		this.setCurrentExp(0);
		this.setNextLv(100);
		this.setInvincibleTime(150);
		this.weapon = new GunNormal();
	}
	
	public void attack(BaseEntity others){	
		if (!(others instanceof EnemyBoss)) {
			others.takeDamage(1000);
		}
	}
	@Override
	public void died() {
	}
	public void takeDamage(int dmg){
		super.takeDamage(dmg);
		if (this.isDamagable()) {hit.play();}
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
				this.PsetX(this.getX()+vx);
				}
			else if(GamePlayPage.background.getX()-vx+GamePlayPage.background.getWidth()<=800) {//right bound
				this.PsetX(this.getX()+vx);
				}
			else {
				if(this.getX()<400) {
					if(this.getX()+vx>400) {
						this.PsetX(400);
						}
					else {
						this.PsetX(this.getX()+vx);
						}
					}
				else if(this.getX()>400) {
					if(this.getX()+vx<400) {
						this.PsetX(400);
						}
					else {
						this.PsetX(this.getX()+vx);
						}
					}
				else {
					GamePlayPage.background.setX(GamePlayPage.background.getX()-vx);
					}
			}
			BookBullet.followXPlayer(vx);
			}
				
		if(GamePlayPage.background.getY()<=0 || GamePlayPage.background.getY()+GamePlayPage.background.getHeight()>600) {//Y-axis
			if(GamePlayPage.background.getY()-vy>=0) {//top bound
				GamePlayPage.background.setY(0);
				this.PsetY(this.getY()+vy);
				}
			else if(GamePlayPage.background.getY()-vy+GamePlayPage.background.getHeight()<=600) {//bottom bound
				this.PsetY(this.getY()+vy);
				}
			else {
				if(this.getY()<300) {
					if(this.getY()+vy>300) {
						this.PsetY(300);
						}
					else {
						this.PsetY(this.getY()+vy);
						}
					}
				else if(this.getY()>300) {
					if(this.getY()+vy<300) {
						this.PsetY(300);
						}
					else {
						this.PsetY(this.getY()+vy);
						}
					}
				else {
					GamePlayPage.background.setY(GamePlayPage.background.getY()-vy);
					}
				}
			BookBullet.followYPlayer(vy);
			}
	}

	public void shoot(int x, int y){
		weapon.shoot(this.getX(), this.getY(), x, y);
	}
	
	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(this.getColor());
		gc.fillOval(this.getX()-25, this.getY()-25, 50, 50);
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
	public void PsetX(double x) {
		this.setX(Math.max(25, Math.min(775, x)));
	}
	public void PsetY(double y) {
		this.setY(Math.max(25, Math.min(575, y)));
	}

	public ArrayList<EffectWeapon> getSkillsWeapon() {
		return skillsWeapon;
	}

	public void setSkillsWeapon(ArrayList<EffectWeapon> skillsWeapon) {
		this.skillsWeapon = skillsWeapon;
	}

	public int getCurrentexp() {
		return currentexp;
	}

	public void setCurrentexp(int currentexp) {
		this.currentexp = currentexp;
	}

	public BaseWeapon getWeapon() {
		return weapon;
	}

	public void setWeapon(BaseWeapon weapon) {
		this.weapon = weapon;
	}
	public boolean isUltiReady() {
		return ultiReady;
	}

	public void setUltiReady(boolean ultiReady) {
		this.ultiReady = ultiReady;
	}
}
