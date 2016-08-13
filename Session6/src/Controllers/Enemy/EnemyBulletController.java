package Controllers.Enemy;


import Controllers.Colliable;
import Controllers.PlaneController;
import Controllers.SingleController;
import Models.EnemyBullet;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/3/2016.
 */
class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            colliable.getGameObject().destroy();
        }
    }
}
