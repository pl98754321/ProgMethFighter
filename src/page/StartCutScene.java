package page;

import java.util.ArrayList;
import java.util.Arrays;

import Controller.SSController;
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
	public static int currentStage = 0;
	private ArrayList<String> lores = new ArrayList<String>(Arrays.asList(
			"ในระหว่างการสอบ ปีศาจ ProgMeth ได้บุกเข้ามา\nเหล่าผู้กล้าเอ๋ย จงกำดาบต่อสู้เพื่ออิสรภาพเอาชีวิตรอดไปปั่น Project ซะ",
			"คุณได้ไล่ตามปีศาจProgMeth ที่หนีไปจนถึงวงเวทย์กับดักที่วางไว้\nคุณโดนสาปให้อ่อนแอลง จงรวบรวมพลังไปต่อกรอีกครั้งเพื่อจบทุกสิ่ง",
			"หลังจากทุกอย่างจบลง คุณไปเที่ยวกับเพื่อนๆ \nแต่เหมือนปีศาจProgMethอยากจะเล่นกับคุณด้วย ไปเล่นกับเค้าสิ XD"));

	public static Scene getStartCutScenePageScene(int index) {
		StartCutScene page = new StartCutScene();
		page.initializeStartCutScenePage(index);
		return page.scene;
	}

	public void initializeStartCutScenePage(int index) {
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

		Text ready = new Text(lores.get(index));
		ready.setFill(Color.WHITE);
		ready.setFont(Font.font(20));

		container.getChildren().addAll(nameStage, ready);

		root.getChildren().addAll(black, container);

		scene = new Scene(root, 800, 600);

		Thread t = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Platform.runLater(() -> {
				StartPage.bgSong.stop();
				Stage thisStage = (Stage) scene.getWindow();
				thisStage.setScene(GamePlayPage.getGamePlayPage());
			});

		});
		t.start();

	}
}
