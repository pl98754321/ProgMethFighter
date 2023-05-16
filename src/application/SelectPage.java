package application;

import java.io.IOException;
import StageSelection.SSController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelectPage {
	public FXMLLoader loader;
	public Parent root2;
	public Scene scene2;
	public SSController myController;
	
	public static Scene getSelectScene() throws IOException {
		SelectPage page = new SelectPage();
		page.initializeSelectPage();
		return page.scene2;
	}
	
	public void initializeSelectPage() throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("SSFXML.fxml"));
		root2 = loader.load();
		scene2 = new Scene(root2,800,600);
		myController = loader.getController();
		scene2.setOnKeyPressed(e -> {
			switch(e.getCode()) {
				case A:
					myController.slideleft();
					break;
				case D:
					myController.slideright();	
					break;
				case S:
					Stage thisStage = (Stage) ((Scene) e.getSource()).getWindow();
					thisStage.setScene(GamePlayPage.getGamePlayPage());
					break;	
				default:
					break;
				}
			});
	}
}
