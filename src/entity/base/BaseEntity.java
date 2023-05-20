package entity.base;

public abstract class BaseEntity extends BaseObjective{
	private int Hp;
	private int maxHP;
	
	public BaseEntity(int x,int y,int size,int speed) {
		super(x,y,size,speed);
		this.setMaxHP(100);
		this.setHp(100);
	}
	// getter setter
	public void setHp(int hp) {
		this.Hp = Math.max(0, Math.min(maxHP, hp));
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
}
