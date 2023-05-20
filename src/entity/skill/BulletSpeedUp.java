package entity.skill;

import entity.base.BaseSkill;
import entity.base.BaseWeapon;
import entity.base.EffectWeapon;

public class BulletSpeedUp extends BaseSkill implements EffectWeapon{

	public BulletSpeedUp() {
		super("BulletSpeedUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(BaseWeapon weapon) {
		// TODO Auto-generated method stub
		weapon.setSpeed((int)(weapon.getSpeed()*1.5));
	}
	
}
