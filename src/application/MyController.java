package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;


public class MyController{
	@FXML
	private Rectangle player;
	@FXML
	private AnchorPane scene;
	@FXML
	private Button getCurrentPos;
	@FXML
	private Button makeTarget;

	
	public void moveUp() {
		player.setY(Math.max(-275,player.getY()-10));
	}
	public void moveDown() {
		player.setY(Math.min(275,player.getY()+10));
	}
	public void moveLeft() {
		player.setX(Math.max(-275,player.getX()-10));
	}
	public void moveRight() {
		player.setX(Math.min(275,player.getX()+10));
	
	}
	public void getCurrentPos(ActionEvent e){
		System.out.println("X = "+player.getX());
		System.out.println("Y = "+player.getY());
	}

	
	
	
	

	
	

}
