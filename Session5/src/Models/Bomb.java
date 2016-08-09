package Models;

/**
 * Created by giaqu on 8/5/2016.
 */
public class Bomb extends GameObject {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    public Bomb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Bomb(int x, int y){
        super(x, y, WIDTH, HEIGHT);
    }
}
