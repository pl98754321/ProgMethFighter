package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterA extends BaseEntity implements KnockBackAble {
	 
	public MonsterA(int Hp,int speed,ArrayList<Integer> position) {
		super(Hp,speed,position);
	}
	
	
	
	
	public void KnockBack(Player p,int distance) {
		// TODO Auto-generated method stub
		//setPosition something
		int dx = p.getPosition().get(0)-this.getPosition().get(0);
		int dy = p.getPosition().get(1)-this.getPosition().get(1);
		int abs =(int) Math.pow(Math.pow(dx, 2)+Math.pow(dy, 2),(1/2));
//		newPos={(int)5*dx/abs,(int)5*dy/abs}  knockback ห่างออกจาก player 5 ในทิศตรงข้าม player  ทำไงน้าาาา
//		
//		this.setPosition(newPos);

	}


}
