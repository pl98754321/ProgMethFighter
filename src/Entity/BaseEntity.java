package Entity;

public abstract class BaseEntity extends BaseObjective{
	private int Hp;
	private int maxHP;
	
	public BaseEntity(int x,int y,int size) {
		super(x,y,size);
		this.maxHP = 100;
		this.setHp(100);
	}
	// getter setter
	public void setHp(int hp) {
		this.Hp = Math.max(0, Math.min(maxHP, hp));
		if(this.Hp==0) {
			if(this instanceof Player) {
				System.out.println("you not win");
			}
		}
	}
	public int getHp() {
		return this.Hp;
	}
}
