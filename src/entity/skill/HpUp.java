package entity.skill;

import entity.base.BaseSkill;
import entity.base.EffectPlayer;
import entity.unit.Player;

public class HpUp extends BaseSkill implements EffectPlayer{

	public HpUp() {
		super("HpUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(Player player) {
		player.setMaxHP(player.getMaxHP()+10);
		player.setHp(player.getHp()+10);
	}

}
