package applicationTry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Controller{
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
	
	public void slide(ActionEvent e) {
		if(center.getFill()==Color.RED) {
			center.setFill(Color.BLUE);
			right.setFill(Color.RED);
			left.setFill(Color.RED);
		}
		else {
			center.setFill(Color.RED);
			right.setFill(Color.BLUE);
			left.setFill(Color.BLUE);
		}
	}
}
