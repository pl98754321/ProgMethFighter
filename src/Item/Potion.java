package Item;

import Entity.Player;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class Potion extends BaseItem {
	public final int HP=5;
	private AudioClip healSound = new AudioClip(ClassLoader.getSystemResource("audio/heal.mp3").toString()); 
	public Potion(int x, int y) {
		super(x,y,10);
		this.setColor(Color.LIGHTBLUE);
	}

	@Override
	public void performEffect(Player player) {
		healSound.play();
		player.setHp(player.getHp()+this.HP);
	}
		
		
}	
