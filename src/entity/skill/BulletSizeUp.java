package entity.skill;

import entity.base.BaseSkill;
import entity.base.BaseWeapon;
import entity.base.EffectWeapon;

public class BulletSizeUp extends BaseSkill implements EffectWeapon{

	public BulletSizeUp() {
		super("BulletSizeUp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performEffect(BaseWeapon weapon) {
		// TODO Auto-generated method stub
		weapon.setSize((int)(weapon.getSize()*1.5));
	}
	
}
