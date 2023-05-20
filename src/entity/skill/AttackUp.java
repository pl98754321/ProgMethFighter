package entity.skill;

import entity.base.BaseSkill;
import entity.base.EffectPlayer;
import entity.unit.Player;

public class AttackUp extends BaseSkill implements EffectPlayer{

	public AttackUp() {
		super("AttackUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(Player player) {
		player.setAtk(player.getAtk()+5);
		
	}

}
