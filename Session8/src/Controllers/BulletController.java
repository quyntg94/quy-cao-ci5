package Controllers;

import Controllers.Enemy.EnemyController;
import Models.Bullet;
import Models.GameObjectWithHP;
import Views.GameDrawer;

/**
 * Created by giaqu on 7/30/2016.
 */
public class BulletController extends SingleController implements Colliable {

    private static final int SPEED = 20;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            Bullet bullet = (Bullet)gameObject;
            GameObjectWithHP target = (GameObjectWithHP) colliable.getGameObject();
            //((GameObjectWithHP) colliable.getGameObject()).decreaseHP(bullet.getDamage());
            this.getGameObject().destroy();

            ((EnemyController) colliable).destroy();
        }
    }
}


