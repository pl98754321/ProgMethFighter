package entity.skill;

import entity.base.BaseSkill;
import entity.base.BaseWeapon;
import entity.base.EffectPlayer;
import entity.base.EffectWeapon;
import entity.unit.Player;
import entity.weapon.Book;
import entity.weapon.Gun;

public class ChangeWeapon extends BaseSkill implements EffectPlayer{

	public ChangeWeapon() {
		super("AttackSpeedUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(Player player) {
		// TODO Auto-generated method stub

		if (player.getWeapon() instanceof Gun ) {
			player.setWeapon(new Book());
		}
		else {
			player.setWeapon(new Gun());
		}
	}
	
}
