package Models;

/**
 * Created by giaqu on 8/10/2016.
 */
public class Bomb extends GameObject {

    public final static int WIDTH = 13;
    public final static int HEIGHT = 30;

    public Bomb(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
