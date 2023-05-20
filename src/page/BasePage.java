package page;

import javafx.scene.Scene;

public abstract class BasePage {
	public Scene scene;
	public Scene getScene() {
		this.initializePage();
		return this.scene;
	}
	
	public abstract BasePage getThisPage();
	public abstract void initializePage();
}
