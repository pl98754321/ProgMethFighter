package entity.skill;

import entity.base.BaseSkill;
import entity.base.BaseWeapon;
import entity.base.EffectWeapon;

public class AttackUp extends BaseSkill implements EffectWeapon{

	public AttackUp() {
		super("AttackUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(BaseWeapon weapon) {
		weapon.setAtk(weapon.getAtk()+5);
	}

}
