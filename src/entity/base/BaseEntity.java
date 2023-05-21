package entity.base;

import entity.unit.Enemy;
import javafx.scene.paint.Color;
import logic.Utility;

public abstract class BaseEntity extends BaseObject {
	private int Hp;
	private int maxHP;
	private int atk;
	private boolean isDamagable = true;
	private int invincibleTime = 0;

	public BaseEntity(double x, double y, int size, int speed, Color color, int hp, int atk) {
		super(x, y, size, speed, color);
		if (hp <= 1) {
			hp = 1;
		}
		this.setMaxHP(hp);
		this.setHp(hp);
		this.setAtk(atk);
	}

	public abstract void died();

	public void takeDamage(int dmg) {
		if (isDamagable) {
			this.setHp(this.getHp() - dmg);
			isDamagable = false;
			Utility.coolDown(invincibleTime, () -> isDamagable = true);
		}
	}

	public void attack(BaseEntity others) {
		others.takeDamage(this.getAtk());
		if (others instanceof Enemy) {
			((Enemy) others).knockBack(this);
		}
	}

	// getter setter
	public void setHp(int hp) {
		this.Hp = Math.max(0, Math.min(maxHP, hp));
		if (this.Hp <= 0) {
			this.died();
		}
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getHp() {
		return this.Hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int attack) {
		this.atk = attack;
	}

	public boolean isDamagable() {
		return isDamagable;
	}

	public void setDamagable(boolean isDamagable) {
		this.isDamagable = isDamagable;
	}

	public int getInvincibleTime() {
		return invincibleTime;
	}

	public void setInvincibleTime(int invincibleTime) {
		this.invincibleTime = invincibleTime;
	}
}
