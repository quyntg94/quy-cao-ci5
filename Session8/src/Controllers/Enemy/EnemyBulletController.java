package Controllers.Enemy;


import Controllers.Colliable;
import Controllers.CollisionPool;
import Controllers.PlaneController;
import Controllers.SingleController;
import Models.GameObject;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/3/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            //            colliable.getGameObject().destroy();
            ((PlaneController) colliable).decreaseHP(1);

        }
    }
}
