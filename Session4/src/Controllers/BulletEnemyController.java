package Controllers;

import Models.GameObject;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/2/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable{

    private final static int SPEED = 10;

    public BulletEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() > 600) {
            gameObject.destroy();
        }
    }


    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            PlaneController.planeController.getGameObject().setHp(PlaneController.planeController.gameObject.getHp() - 1);
        }
    }
}
