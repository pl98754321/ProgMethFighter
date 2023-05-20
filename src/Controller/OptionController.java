package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class OptionController {
	@FXML
	private Rectangle selected;
	@FXML
	private ImageView left = new ImageView(new Image((String) (ClassLoader.getSystemResource("optionCard/atk+.png").toString())));
	@FXML
	private ImageView right = new ImageView(new Image((String) (ClassLoader.getSystemResource("optionCard/barrier.png").toString())));
	@FXML
	private ImageView  center =new ImageView( new Image((String) (ClassLoader.getSystemResource("optionCard/Bspeed.png").toString())));
	@FXML
	private Button Confirm;
	public static int Selected = 0;
	
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
		System.out.println("ok");
	}
	
}
