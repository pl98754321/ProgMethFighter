package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import entity.base.BaseSkill;
import entity.base.EffectPlayer;
import entity.base.EffectWeapon;
import entity.skill.ChangeWeapon;
import entity.skill.HpUp;
import entity.skill.SpeedUp;
import entity.skill.AttackSpeedUp;
import entity.skill.AttackUp;
import entity.skill.BulletSizeUp;
import entity.skill.BulletSpeedUp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import page.GamePlayPage;
import page.OptionPage;


public class OptionController {
	@FXML
	private Rectangle selected;
	@FXML
	private ImageView left = new ImageView(new Image((String) (ClassLoader.getSystemResource("optionCard/atk+.png").toString())));;
	@FXML
	private ImageView right = new ImageView(new Image((String) (ClassLoader.getSystemResource("optionCard/Hp.png").toString())));;
	@FXML
	private ImageView center = new ImageView(new Image((String) (ClassLoader.getSystemResource("optionCard/spd+.png").toString())));;
	@FXML
	private Button Confirm;
	public static int Selected = 0;
	private ArrayList<String> name = new ArrayList<String>(Arrays.asList(
			"atk+", 
			"atkSpeed", 
			"barrier", 
			"Bsize", 
			"Bspeed",
			"Hp",
			"spd+"));
    private Map<String, BaseSkill> mapSkill = Map.of(
    		"atk+", new AttackUp() , 
    		"atkSpeed",new AttackSpeedUp() , 
    		"barrier", new ChangeWeapon(),
    		"Bsize", new BulletSizeUp(),
    		"Bspeed", new BulletSpeedUp(),
    		"Hp", new HpUp(),
    		"spd+",new SpeedUp()
    		);
	
	public void intialize() {
		Selected=0;
		Collections.shuffle(name);
		left.setImage(new Image((String) (ClassLoader.getSystemResource("optionCard/"+name.get(0)+".png").toString())));
        center.setImage(new Image((String) (ClassLoader.getSystemResource("optionCard/"+name.get(1)+".png").toString())));
        right.setImage(new Image((String) (ClassLoader.getSystemResource("optionCard/"+name.get(2)+".png").toString())));
	}
	
	public void toLeft() {
		if(Selected>0) {
			Selected-=1;
			selected.setX(selected.getX()-250);
		}
	}
	public void toRight() {
		if(Selected<2) {
			Selected+=1;
			selected.setX(selected.getX()+250);
		}
	}
	public void confirm() {
		BaseSkill skill = mapSkill.get(name.get(Selected));
		if (skill instanceof  EffectPlayer) {
			((EffectPlayer) skill).performEffect(GamePlayPage.player);
		}
		else if (skill instanceof  EffectWeapon) {
			GamePlayPage.player.getSkillsWeapon().add((EffectWeapon) skill);
			((EffectWeapon) skill).performEffect(GamePlayPage.player.getWeapon());
		}
		else {
			System.out.println("Enermy :: " + name.get(Selected));
		}
	}
	
}
