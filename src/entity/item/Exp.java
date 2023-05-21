package entity.item;

import entity.base.BaseItem;
import entity.base.EffectPlayer;
import entity.unit.Player;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import page.GamePlayPage;

public class Exp extends BaseItem implements EffectPlayer{
	public final int EXP=5;
	private AudioClip levelUp = new AudioClip(ClassLoader.getSystemResource("audio/lvlUP.mp3").toString()); 
	
	public Exp(double x, double y) {
		super(x,y,10,Color.YELLOW);
	}

	@Override
	public void performEffect(Player player) {
		player.setCurrentExp(player.getCurrentExp()+this.EXP);//add player EXP
		if(player.getCurrentExp()>=player.getNextLv()) {//player level up
			player.setLv(player.getLv()+1);
			player.setCurrentExp(player.getCurrentExp()-player.getNextLv());
			levelUp.play();
			GamePlayPage.lvlUp=true;
		}
	}	
}
