package Entity;

import java.util.ArrayList;

import Skill.Skill;

public class Player extends BaseEntity {
	private int Lv;
	private ArrayList<Skill>skill;

	
	public Player(int Hp,int speed,ArrayList<Integer> position,ArrayList<Skill>skill) {
		super(Hp,speed,position);
		this.setLv(1);
		skill =new ArrayList<Skill>();
	}
	
	public int getLv() {
		return this.Lv;
	}
	public void setLv(int lv) {
		this.Lv = Math.max(1, lv);
	}
	public ArrayList<Skill> getSkill() {
		return skill;
	}
	public void setSkill(ArrayList<Skill> skill) {
		this.skill = skill;
	}
	public void addSkill(Skill skill) {
		this.getSkill().add(skill);
	}
	
}