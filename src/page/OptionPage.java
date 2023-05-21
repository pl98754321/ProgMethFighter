package page;

import java.io.IOException;

import Controller.OptionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Utility;

public class OptionPage {
	public FXMLLoader loader;
	public Parent root2;
	public Scene scene;
	public OptionController myController;
	
	public static Scene getOptionScene() throws IOException {
		GamePlayPage.lvlUp=false;
		OptionPage page = new OptionPage();
		page.initializeOptionPage();
		return page.scene;
	}
	
	public void initializeOptionPage() throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("optionPage.fxml"));
		root2 = loader.load();
		scene = new Scene(root2,800,600);
		Utility.coolDown(300, () -> {
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
					case F:
						myController.confirm();
						Stage thisStage = (Stage) scene.getWindow();
						thisStage.setScene(GamePlayPage.tempPage);
						GamePlayPage.isback=true;
						break;	
					default:
						break;
					}
				});
		});
		
	}
}
