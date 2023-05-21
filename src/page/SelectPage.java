package page;

import java.io.IOException;

import Controller.SSController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Utility;

public class SelectPage {
	public FXMLLoader loader;
	public Parent root2;
	public Scene scene2;
	public SSController myController;
	private boolean canClick = false;
	
	public static Scene getSelectScene() throws IOException {
		SelectPage page = new SelectPage();
		page.initializeSelectPage();
		return page.scene2;
	}
	
	public void initializeSelectPage() throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("SSFXML.fxml"));
		root2 = loader.load();
		scene2 = new Scene(root2,800,600);
		Utility.coolDown(500, ()-> this.canClick = true);
		myController = loader.getController();
		scene2.setOnKeyPressed(e -> {
			switch(e.getCode()) {
				case A:
					myController.slideleft();
					break;
				case D:
					myController.slideright();	
					break;
				case F:
					if(this.canClick) {
						Stage thisStage = (Stage) ((Scene) e.getSource()).getWindow();
						thisStage.setScene(StartCutScene.getStartCutScenePageScene(SSController.selectedStage()-1));
						this.canClick = false;
						break;	
					}
				default:
					break;
				}
			});
	}
}
