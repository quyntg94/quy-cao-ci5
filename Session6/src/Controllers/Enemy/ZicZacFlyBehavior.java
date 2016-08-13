package Controllers.Enemy;

/**
 * Created by giaqu on 8/13/2016.
 */
public class ZicZacFlyBehavior implements FlyBehavior{

    private int count;

    public ZicZacFlyBehavior() {
        this.count = 0;
    }

    @Override
    public void doFly(EnemyController enemyController) {
        count++;
        if (count == 1) {
            enemyController.getGameVector().dx = enemyController.SPEED;
        }
        if (enemyController.getGameObject().getX() >=600 || enemyController.getGameObject().getX() <= 0){
            enemyController.getGameVector().dx = -enemyController.getGameVector().dx;
        }
    }

}
