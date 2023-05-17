package application;

import java.io.IOException;

import Entity.Player;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultPage {
	GridPane root4;
	Text resultText;
	Button restart;
	Player player;
	Button menu;
	Scene scene4;
	
	public static Scene getResultPage(int result) {
		ResultPage page = new ResultPage();
		page.initializeResultPage(result);
		return page.scene4;
	}
	public void initializeResultPage(int result){
		root4 = new GridPane();
		root4.setBackground(Background.fill(Color.GRAY));
		root4.setAlignment(Pos.CENTER);
		root4.setHgap(15);
		root4.setVgap(15);
		if(result==1) {
			resultText = new Text("YOU WIN");
			resultText.setFill(Color.GOLD);
		}
		else if(result ==0) {
			resultText = new Text("YOU LOSE");
			resultText.setFill(Color.RED);
		}
		resultText.setFont(Font.font(50));
		
		GamePlayPage.keys.clear();
		GamePlayPage.items.clear();
		GamePlayPage.enemies.clear();
		player = new Player(350, 250);
		
		restart = new Button("----RESTART----");
		restart.setOnMouseClicked(e -> {
			
			Stage thisStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			try {
				thisStage.setScene(SelectPage.getSelectScene());
			} catch (IOException e1) {}
		});
			menu = new Button(" -MAIN MENU- ");
			menu.setOnMouseClicked(e -> {
				Stage thisStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				thisStage.setScene(StartPage.getStartPageScene());
				});
			root4.add(resultText, 0, 0,2,1);
			root4.add(restart,0,1);
			root4.add(menu,1,1);
			scene4 =new Scene(root4,800,600);
		}
	
	
	
	
	

	

	

		

	
}
