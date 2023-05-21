package entity.item;

import entity.base.BaseItem;
import entity.base.EffectPlayer;
import entity.unit.Player;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class Potion extends BaseItem implements EffectPlayer{
	private int HP=5;
	private AudioClip healSound = new AudioClip(ClassLoader.getSystemResource("audio/heal.mp3").toString()); 
	public Potion(double x, double y) {
		super(x,y,10,Color.LIGHTBLUE);
	}

	@Override
	public void performEffect(Player player) {
		healSound.play();
		player.setHp(player.getHp()+this.HP);
	}	
}	
