package application;

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
	public static boolean result;
	GridPane root4;
	Text lose;
	Button restart;
	Player player;
	Button menu;
	Scene scene4;
	
	public static Scene getDeathPage() {
		ResultPage page = new ResultPage();
		page.initializeStartPage();
		return page.scene4;
	}
	public void initializeStartPage(){
		root4 = new GridPane();
		root4.setBackground(Background.fill(Color.GRAY));
		root4.setAlignment(Pos.CENTER);
		root4.setHgap(15);
		root4.setVgap(15);
		if(result) {
			lose = new Text("YOU win");
		}
		else{
			lose = new Text("YOU LOSE");
		}
		lose.setFont(Font.font(50));
		lose.setFill(Color.RED);
		
		restart = new Button("----RESTART----");
		restart.setOnMouseClicked(e -> {
			player = new Player(350, 250);
			GamePlayPage.keys.clear();
			GamePlayPage.items.clear();
			GamePlayPage.enemies.clear();
			Stage thisStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			thisStage.setScene(GamePlayPage.getGamePlayPage());
		});
			menu = new Button(" -MAIN MENU- ");
			menu.setOnMouseClicked(e -> {
				player = new Player(350, 250);
				player.setX(350);
				player.setY(250);
				GamePlayPage.keys.clear();
				GamePlayPage.items.clear();
				GamePlayPage.enemies.clear();
				Stage thisStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				thisStage.setScene(StartPage.getStartPageScene());
				});
			root4.add(lose, 0, 0,2,1);
			root4.add(restart,0,1);
			root4.add(menu,1,1);
			scene4 =new Scene(root4,800,600);
		}
	
	
	
	
	

	

	

		

	
}
