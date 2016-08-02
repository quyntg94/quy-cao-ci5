package Models;

import java.awt.*;

/**
 * Created by giaqu on 7/30/2016.
 */
public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int hp;

    protected boolean isAlive;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int middleX() {
        return this.x + this.width / 2;
    }

    public GameObject(int x, int y, int width, int height, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hp = hp;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(GameVector gameVector) {
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }

    public void destroy() {
        this.isAlive = false;
    }

    public boolean overlap(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }

    private Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }
}
