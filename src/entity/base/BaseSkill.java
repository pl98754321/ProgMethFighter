package entity.base;


public abstract class BaseSkill {
	private String name;
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
