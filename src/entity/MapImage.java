package entity;

import javafx.scene.image.Image;

public class MapImage extends Image {
	private int X,Y;
	
	public MapImage(String url,int x,int y) {
		super(url);
		this.setX(x);
		this.setY(y);
	}
	
	public int getX() {
		return X;
	}


	public void setX(int x) {
		this.X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		this.Y = y;
	}
	
}
