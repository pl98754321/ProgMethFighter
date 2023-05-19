package Skill;

import Entity.Player;

public abstract class BaseSkill {
	String name;
	public BaseSkill(String name) {
		this.name = name;
	}
	
	public abstract void performEffect(Player player);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
