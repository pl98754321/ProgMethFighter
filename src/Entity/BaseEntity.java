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
		hp = Math.min(maxHP, hp);
		this.Hp = Math.max(0, hp);
		if(this.Hp==0) {
			System.out.println("you not win");
		}
	}
	public int getHp() {
		return this.Hp;
	}
}
