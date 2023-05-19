package Skill;

import Entity.Player;

public class SpeedUp extends BaseSkill{

	public SpeedUp() {
		super("SpeedUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(Player player) {
		player.setSpeed(player.getSpeed()+2);
		
	}

}
