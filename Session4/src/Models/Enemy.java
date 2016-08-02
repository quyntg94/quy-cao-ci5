package Models;

/**
 * Created by giaqu on 7/29/2016.
 */
public class Enemy extends GameObject {

    public final static int DEFAULT_WIDTH = 45;
    public final static int DEFAULT_HEIGHT = 30;
    public final static int HP = 10;

    public Enemy(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }

    public Enemy(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, HP);
    }
}
