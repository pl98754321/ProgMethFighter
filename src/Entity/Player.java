package Entity;


import java.util.ArrayList;
import Bullet.Bullet;
import application.GamePlay;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends BaseEntity {
	private int hp = 100;
	private int currentexp=0;
	private int nextLv;
	private int Lv;
	public int getCurrentexp() {
		return currentexp;
	}

	public void setCurrentexp(int currentexp) {
		this.currentexp = currentexp;
	}

	public int getNextLv() {
		return this.nextLv;
	}

	public void setNextLv(int nextLv) {
		this.nextLv = nextLv;
	}

	public static ArrayList<Bullet> bullets = new ArrayList<>();
	public static final int SPEED=3;
	private boolean shooting = false, damage = false;
	
	public Player(int Hp,int x, int y){
		super(Hp,x,y);
		this.setLv(1);
		this.setCurrentExp(0);
		this.Lv=1;
		this.nextLv=100;
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

	public void setHp(int hp) {
		this.hp = this.hp;
	}

	public int getHp(){
		return this.hp;
	}
	
	public void takeDamage(int dmg){
		if (damage) return;
		this.hp -= dmg;
		damage = true;
		GamePlay.shedule(150, () -> damage = false);
	}
	
	public void render(GraphicsContext gc){
		gc.setFill(Color.BLUE);
		gc.fillOval(this.getX(), this.getY(), 50, 50);
		for (int i = 0; i < this.bullets.size(); i++){
			this.bullets.get(i).update(gc);
		}
	}
	
	public void shoot(double x, double y){
		if (shooting) return;
		shooting = true;
		GamePlay.shedule(200, () -> this.shooting = false);
		double direction = Math.atan2(y-this.getY(), x-this.getX());
		Bullet b = new Bullet(direction, this.getX()+20, this.getY()+20);
		this.bullets.add(b);
	}
}
