package entity.skill;

import entity.base.BaseSkill;
import entity.base.BaseWeapon;
import entity.base.EffectWeapon;

public class AttackSpeedUp extends BaseSkill implements EffectWeapon{

	public AttackSpeedUp() {
		super("AttackSpeedUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(BaseWeapon weapon) {
		// TODO Auto-generated method stub
		weapon.setCoolDown((int)(weapon.getCoolDown()/1.3));
	}
	
}
