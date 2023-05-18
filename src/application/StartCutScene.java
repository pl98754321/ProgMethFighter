package application;

import StageSelection.SSController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartCutScene {
	public StackPane root;
	public Scene scene;
	public Text nameStage;
	public VBox container;
	
	public static Scene getStartCutScenePageScene() {
		StartCutScene page = new StartCutScene();
		page.initializeStartCutScenePage();
		return page.scene;
	}
	public void initializeStartCutScenePage() {
		root = new StackPane();
		
		Rectangle black = new Rectangle(800, 6000, Color.BLACK);
		black.setX(0);
		black.setY(0);
		
		container = new VBox(10);
		container.setPadding(new Insets(20));
		container.setAlignment(Pos.CENTER_LEFT);
		
		nameStage = new Text(SSController.getNameStage());
		nameStage.setFill(Color.WHITE);
		nameStage.setFont(Font.font(50));
		
		Text ready = new Text("Ready");
		ready.setFill(Color.WHITE);
		ready.setFont(Font.font(30));
		
		container.getChildren().addAll(nameStage,ready);
		
		root.getChildren().addAll(black,container);
		
		scene =new Scene(root,800,600);
		
		Thread t = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Platform.runLater(() -> {
				Stage thisStage = (Stage) scene.getWindow();
				thisStage.setScene(GamePlayPage.getGamePlayPage());
			});
			
		});
		t.start();
		
	}
}
