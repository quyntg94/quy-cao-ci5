package Controllers;

import Models.Bomb;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/6/2016.
 */
public class BombControllerBlack extends SingleController implements Colliable{

    public static final int SPEED = 2;
    protected int radius;

    public BombControllerBlack(Bomb gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
        this.radius = 800;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            EnemyControllerManager.instance.destroyForRadius(radius, this.getGameObject().getX(), this.gameObject.getY());
            EnemyBulletControllerManager.instance.destroyForRadius(radius, this.getGameObject().getX(), this.gameObject.getY());
        }
    }
}
