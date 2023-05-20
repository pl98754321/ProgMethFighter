package entity.base;

import entity.unit.Player;

public abstract class BaseSkill {
	String name;
	public BaseSkill(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
