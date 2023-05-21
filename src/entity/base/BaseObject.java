package entity.base;

import entity.unit.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import page.GamePlayPage;

/**
 * The BaseObject class represents a basic game object with position, size, speed, and color.
 */
public class BaseObject {
    private double x;
    private double y;
    private int size;
    private int speed;
    private Color color;

    /**
     * Constructs a BaseObject with the specified position, size, speed, and color.
     *
     * @param x     the x-coordinate of the object's position
     * @param y     the y-coordinate of the object's position
     * @param size  the size of the object
     * @param speed the speed of the object
     * @param color the color of the object
     */
    public BaseObject(double x, double y, int size, int speed, Color color) {
        this.setX(x);
        this.setY(y);
        this.setSize(size);
        this.setSpeed(speed);
        this.setColor(color);
    }

    /**
     * Moves the object by the specified amount in the x and y directions.
     *
     * @param vx the amount to move in the x direction
     * @param vy the amount to move in the y direction
     */
    public void move(double vx, double vy) {
        this.setX(this.getX() + vx);
        this.setY(this.getY() + vy);
    }

    /**
     * Moves the object by the specified amount in the x and y directions.
     *
     * @param vx the amount to move in the x direction
     * @param vy the amount to move in the y direction
     */
    public void move(int vx, int vy) {
        this.move((double) vx, (double) vy);
    }

    /**
     * Moves the object towards the player based on the current game background position.
     *
     * @param player the player object to move towards
     */
    public void move(Player player) {
        if (this.distance(player) >= 0) {
            double angle = Math.atan2(-GamePlayPage.background.getY() + player.getY() - this.getY(),
                    -GamePlayPage.background.getX() + player.getX() - this.getX());
            this.move((int) (Math.cos(angle) * this.speed), (int) (Math.sin(angle) * this.speed));
        }
    }

    /**
     * Moves the object towards another object with the specified speed.
     *
     * @param others the other object to move towards
     * @param speed  the speed at which to move
     */
    public void move(BaseObject others, int speed) {
        double angle = Math.atan2(others.getY() - this.getY(), others.getX() - this.getX());
        this.move((int) (Math.cos(angle) * speed), (int) (Math.sin(angle) * speed));
    }

    /**
     * Calculates the distance between the object and the player.
     *
     * @param p the player object
     * @return the distance between the object and the player
     */
    public double distance(Player p) {
        double dis = Math.sqrt(Math.pow(GamePlayPage.background.getX() + x - p.getX(), 2)
                + Math.pow(GamePlayPage.background.getY() + y - p.getY(), 2));
        return dis - this.getSize() / 2 - p.getSize() / 2;
    }

    /**
     * Calculates the distance between the object and another object.
     *
     * @param others the other object
     * @return the distance between the object and the other object
     */
    public double distance(BaseObject others) {
        double dis = Math.sqrt(Math.pow(this.getX() - others.getX(), 2) + Math.pow(this.getY() - others.getY(), 2));
        return dis - this.getSize() / 2 - others.getSize() / 2;
    }

    /**
     * Renders the object on the specified GraphicsContext.
     *
     * @param gc the GraphicsContext to render on
     */
    public void render(GraphicsContext gc) {
        gc.setFill(this.getColor());
        gc.fillOval(GamePlayPage.background.getX() + this.getX() - size / 2,
                GamePlayPage.background.getY() + this.getY() - size / 2, size, size);
    }

    /**
     * Gets the size of the object.
     *
     * @return the size of the object
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Sets the size of the object.
     *
     * @param size the size of the object
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the x-coordinate of the object's position.
     *
     * @return the x-coordinate of the object's position
     */
    public double getX() {
        return this.x;
    }

    /**
     * Sets the x-coordinate of the object's position.
     *
     * @param x the x-coordinate of the object's position
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the object's position.
     *
     * @return the y-coordinate of the object's position
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets the y-coordinate of the object's position.
     *
     * @param y the y-coordinate of the object's position
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the color of the object.
     *
     * @param c the color of the object
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * Gets the color of the object.
     *
     * @return the color of the object
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the speed of the object.
     *
     * @return the speed of the object
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the object.
     *
     * @param speed the speed of the object
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}