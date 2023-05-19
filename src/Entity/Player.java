package Entity;


import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import Skill.BaseSkill;
import Skill.SpeedUp;
import Weapon.BaseWeapon;
import Weapon.Book;
import Weapon.Gun;
import Weapon.GunDagger;
import application.GamePlayPage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.media.AudioClip;

public class Player extends BaseEntity {
	private int currentexp=0;
	private int nextLv;
	private int Lv;
	private int atk; 
	private AudioClip hit  =new AudioClip(ClassLoader.getSystemResource("audio/PlayerHit.mp3").toString());
	private ArrayList<BaseSkill> skills; 
	private BaseWeapon weapon;
	private boolean ultiReady=true; //check player can use ultimate skill
	private boolean damage = false;

	public Player(int x, int y){
		super(x,y,50,3);
		this.setColor(Color.BLUE);
		this.setLv(1);
		this.setCurrentExp(0);
		this.setLv(1);
		this.setNextLv(100);
		this.setAtk(5);
		this.weapon = new Gun();
	}
	
	public void takeDamage(int dmg){
		if (damage) return;
		this.setHp(this.getHp()-dmg);
		damage = true;
		hit.play();
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
		System.out.println(GamePlayPage.background.getX()+this.getX());
		System.out.println(GamePlayPage.background.getY()+this.getY());
		weapon.shoot(GamePlayPage.background.getX()+this.getX(), GamePlayPage.background.getY()+this.getY(), x, y);
	}
	
	public void levelUp() {
		this.setWeapon(new GunDagger());
		(new SpeedUp()).performEffect(this);;
	}
	public int getCurrentexp() {
		return currentexp;
	}

	public void setCurrentexp(int currentexp) {
		this.currentexp = currentexp;
	}

	public void addSkill(int index) {
        Dictionary<Integer, BaseSkill> dict= new Hashtable<>();
        dict.put(1, new SpeedUp());
        dict.put(1, new SpeedUp());
		this.skills.add(dict.get(index));
	}
	
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
	public void setX(int x) {
		this.x=Math.max(25, Math.min(775, x));
	}
	public void setY(int y) {
		this.y = Math.max(25, Math.min(575, y));
	}
	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public ArrayList<BaseSkill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<BaseSkill> skills) {
		this.skills = skills;
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
