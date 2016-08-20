package Controllers.Bomb;


import Controllers.Colliable;
import Controllers.CollisionPool;
import Controllers.PlaneController;
import Controllers.SingleController;
import Models.Lock;
import Views.GameDrawer;
import Views.ImageDrawer;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class LockController extends SingleController implements Colliable {

    public LockController(Lock gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
    }

    public static LockController create(int x, int y) {
        return new LockController(new Lock(x,y), new ImageDrawer("resources/lock.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance.onFrezze(
                    gameObject.getX(),
                    gameObject.getY()
            );
            gameObject.destroy();
        }
    }
}

