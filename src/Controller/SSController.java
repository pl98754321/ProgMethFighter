package Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import page.StartCutScene;
import page.StartPage;

public class SSController{
	@FXML
	private Button slideright;
	@FXML
	private Button slideleft;
	@FXML
	private ImageView left = new ImageView(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
	@FXML
	private ImageView right = new ImageView(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
	@FXML
	private ImageView  center =new ImageView( new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
	@FXML
	private Text nameStage = new Text("the Nightmare Exam Room");
	@FXML
	private ImageView Home;
	@FXML
	private Button Confirm;
	public static int SelectedStage = 1;
	
	public void slideleft() {
		if(SelectedStage == 1 ) {
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
	        center.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
			nameStage.setText("the Curse of ProgMeth");
			SelectedStage=2;
		}
		else if(SelectedStage == 2) {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
			nameStage.setText("after Exam Trip");
			SelectedStage=3;
		}
		else {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
			nameStage.setText("the Nightmare Exam Room");
			SelectedStage=1;
		}
	}
	public void slideright() {
		if(SelectedStage == 1 ) {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
			nameStage.setText("after Exam Trip");
			SelectedStage=3;
		}
		else if(SelectedStage == 3) {
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
	        center.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
			nameStage.setText("the Curse of ProgMeth");
			SelectedStage=2;
		}
		else {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theCurseOfProgMeth.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("Map/theNightmareExamRoom.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Map/chillbeach.png").toString())));
			nameStage.setText("the Nightmare Exam Room");
			SelectedStage=1;
		}
}
	public void goHome() {
		SSController.SelectedStage = 1;
		StartCutScene.currentStage =0;
		Stage thisStage = (Stage) Home.getScene().getWindow();
		thisStage.setScene(StartPage.getStartPageScene());
	}
	public void gameStart() {
		Stage thisStage = (Stage) (Confirm.getScene().getWindow());
		thisStage.setScene(StartCutScene.getStartCutScenePageScene(SSController.selectedStage()-1));
	}
	public static int selectedStage() {
		return SelectedStage;
	}
	public static String getNameStage() {
		if(SelectedStage==1) {
			return "the Nightmare Exam Room";
		}
		else if(SelectedStage==2) {
			return "the Curse of ProgMeth";
		}
		else {
			return "after Exam Trip";
		}
	}
}
