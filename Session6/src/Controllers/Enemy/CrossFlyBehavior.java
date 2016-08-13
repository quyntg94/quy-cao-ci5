package Controllers.Enemy;

/**
 * Created by giaqu on 8/13/2016.
 */
public class CrossFlyBehavior implements FlyBehavior {
    @Override
    public void doFly(EnemyController enemyController) {
        enemyController.getGameVector().dx = enemyController.SPEED;
    }
}
