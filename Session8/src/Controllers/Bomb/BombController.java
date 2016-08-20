package Controllers.Bomb;

import Controllers.Colliable;
import Controllers.CollisionPool;
import Controllers.PlaneController;
import Controllers.SingleController;
import Models.Bomb;
import Utils.Utils;
import Views.GameDrawer;
import Views.ImageDrawer;

/**
 * Created by giaqu on 8/10/2016.
 */
public class BombController extends SingleController implements Colliable {

    public BombController(Bomb gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
    }

    public static BombController create(int x, int y) {
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/bomb.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {

            NotificationCenter.instance
                    .onBomExpode(gameObject.getX(), gameObject.getY());
            Utils.playSound("resources/explosion.wav", false);
            gameObject.destroy();
        }
    }
}

