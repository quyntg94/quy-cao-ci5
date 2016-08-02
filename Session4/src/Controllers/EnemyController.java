package Controllers;

import Models.Enemy;
import Views.GameDrawer;

/**
 * Created by giaqu on 7/31/2016.
 */
public class EnemyController extends SingleController implements Colliable {

    public static final int SPEED = 5;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
