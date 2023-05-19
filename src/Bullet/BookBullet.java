package Bullet;

import Entity.Player;

public class BookBullet extends BaseBullet{
	private double vx;
	private double vy;
	private double r;
	public BookBullet(int x, int y, int size, int speed,int r) {
		super(x, y, size, speed);
		this.vx = 1;
		this.vy = 0;
		this.r = r;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Player player) {
		// TODO Auto-generated method stub
//		double acc = Math.atan2(this.x-player.getX(),this.y-player.getY());
		this.x += (this.x-player.getX())/r/this.getSpeed() ;
		this.y += (this.y-player.getY())/r/this.getSpeed() ;
		this.move((int) (this.x*this.getSpeed()), 
				(int) (this.y*this.getSpeed()));
	}

}
