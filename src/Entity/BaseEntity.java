package Entity;

public abstract class BaseEntity extends BaseObjective{
	private int Hp;
	
	public BaseEntity(int x,int y,int size) {
		super(x,y,size);
		this.setHp(100);
	}
	
	// getter setter
	public void setHp(int hp) {
		this.Hp = Math.max(0, hp);
		if(this.Hp==0) {
			System.out.println("you not win");
		}
	}
	public int getHp() {
		return this.Hp;
	}
}
