package Models;

/**
 * Created by giaqu on 7/29/2016.
 */
public class EnemyPlane {
    public int x;
    public int y;
    public int dx;
    public int dy;

    public EnemyPlane(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }
}
