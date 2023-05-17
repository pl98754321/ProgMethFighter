package StageSelection;

import application.GamePlayPage;
import application.StartPage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SSController{
	@FXML
	private Button slideright;
	@FXML
	private Button slideleft;
	@FXML
	private ImageView left = new ImageView(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
	@FXML
	private ImageView right = new ImageView(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
	@FXML
	private ImageView  center =new ImageView( new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
	@FXML
	private Text nameStage;
	@FXML
	private ImageView Home;
	@FXML
	private Button Confirm;
	public static int SelectedStage = 1;
	
	public void slideleft() {
		if(SelectedStage == 1 ) {
			right.setImage(new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
	        center.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
			nameStage.setText("NameStage 2");
			SelectedStage=2;
		}
		else if(SelectedStage == 2) {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
			nameStage.setText("NameStage 3");
			SelectedStage=3;
		}
		else {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
			nameStage.setText("the Nightmare Exam Room");
			SelectedStage=1;
		}
	}
	public void slideright() {
		if(SelectedStage == 1 ) {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
			nameStage.setText("NameStage 3");
			SelectedStage=3;
		}
		else if(SelectedStage == 3) {
			right.setImage(new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
	        center.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
			nameStage.setText("NameStage 2");
			SelectedStage=2;
		}
		else {
			left.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 2.png").toString())));
			center.setImage(new Image((String) (ClassLoader.getSystemResource("theNightmareExamRoom.png").toString())));
			right.setImage(new Image((String) (ClassLoader.getSystemResource("Stage 3.png").toString())));
			nameStage.setText("the Nightmare Exam Room");
			SelectedStage=1;
		}
}
	public void goHome() {
		Stage thisStage = (Stage) Home.getScene().getWindow();
		thisStage.setScene(StartPage.getStartPageScene());
	}
	public void gameStart() {
		Stage thisStage = (Stage) Home.getScene().getWindow();
		thisStage.setScene(GamePlayPage.getGamePlayPage());
	}
	public static int selectedStage() {
		return SelectedStage;
	}
}
