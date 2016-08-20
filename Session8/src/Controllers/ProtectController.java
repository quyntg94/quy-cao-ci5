package Controllers;

import Controllers.Enemy.EnemyController;
import Models.GameObject;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/20/2016.
 */
public class ProtectController extends SingleController implements Colliable {

    private double RADIUS = 100;
    private int SPEED = 15;
    private int COOLDOWN = 200;
    private int count;
    private int cooldown;
    private double radian = 0;

    public ProtectController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);

        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        count++;
        cooldown++;
        if (count == SPEED) {
            count = 0;
            this.getGameObject().moveTo(
                    (int) (PlaneController.instance.getGameObject().getMiddleX() - RADIUS * Math.cos(radian)),
                    (int) (PlaneController.instance.getGameObject().getMiddleY() - RADIUS * Math.sin(radian))
            );
            radian++;
            if (radian == 360) {
                radian = 0;
            }
        }
        if (cooldown == COOLDOWN) {
            this.getGameObject().destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            ((EnemyController) colliable).destroy();
        }
    }

}
