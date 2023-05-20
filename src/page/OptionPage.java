package page;

import java.io.IOException;

import Controller.OptionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class OptionPage {
	public FXMLLoader loader;
	public Parent root2;
	public Scene scene;
	public OptionController myController;
	
	public static Scene getOptionScene() throws IOException {
		OptionPage page = new OptionPage();
		page.initializeOptionPage();
		return page.scene;
	}
	
	public void initializeOptionPage() throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("optionPage.fxml"));
		root2 = loader.load();
		scene = new Scene(root2,800,600);
		myController = loader.getController();
		myController.intialize();
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
				case A:
					myController.toLeft();
					break;
				case D:
					myController.toRight();	
					break;
				case S:
					myController.confirm();
					break;	
				default:
					break;
				}
			});
	}
}
