package Controllers;

import Models.BulletEnemy;
import Models.Enemy;
import Views.ImageDrawer;

import java.util.Random;

/**
 * Created by giaqu on 7/31/2016.
 */
public class EnemyManager extends ControllerManager {

    private Random rand = new Random();

    private EnemyManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        int enX = rand.nextInt(800);
        int enY = rand.nextInt(200);
        for (int i = 0; i < 5; i++) {
            EnemyController enemyController = new EnemyController(
                    new Enemy(enX, enY),
                    new ImageDrawer("resources/plane1.png")
            );
            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                    new BulletEnemy(enX,enY),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            this.add(enemyController);
            this.add(bulletEnemyController);
        }

    }

    public final static EnemyManager instance = new EnemyManager();
}
