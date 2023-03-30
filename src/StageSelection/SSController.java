package StageSelection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SSController{
	@FXML
	private Button slideright;
	@FXML
	private Button slideleft;
	@FXML
	private Rectangle right;
	@FXML
	private Rectangle left;
	@FXML
	private Rectangle center;
	@FXML
	private Text numStage;
	
	private int SelectedStage = 1;
	
	public void slide() {
		if(center.getFill()==Color.RED) {
			center.setFill(Color.BLUE);
			right.setFill(Color.RED);
			left.setFill(Color.RED);
			numStage.setText("NameStage 2");
			SelectedStage=2;
		}
		else {
			center.setFill(Color.RED);
			right.setFill(Color.BLUE);
			left.setFill(Color.BLUE);
			numStage.setText("NameStage 1");
			SelectedStage=1;
		}
	}
	public void toGamePlay() {
		System.out.println("Game start");
		System.out.println("Select : Stage "+SelectedStage);
		
	}
}
