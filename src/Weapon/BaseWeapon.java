package Weapon;

import Skill.Skill;

public abstract class BaseWeapon {
	private int attack;
	private int speed;
	private Skill skill;
	
	public BaseWeapon(int attack,int speed,Skill skill) {
		this.setAttack(attack);
		this.setSpeed(speed);
		this.setSkill(skill);
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = Math.max(0, attack);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = Math.max(0, speed);
	}
}
