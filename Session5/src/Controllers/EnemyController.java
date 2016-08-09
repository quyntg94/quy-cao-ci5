package Controllers;

import Models.Enemy;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/3/2016.
 */
public class EnemyController extends SingleController implements Colliable {

    public static final int SPEED = 3;
    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}

