package Models;

/**
 * Created by giaqu on 8/19/2016.
 */
public class Explosion extends GameObject {
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    public Explosion(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
