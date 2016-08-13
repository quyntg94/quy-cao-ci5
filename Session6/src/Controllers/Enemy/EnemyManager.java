package Controllers.Enemy;

import Controllers.ControllerManager;


/**
 * Created by giaqu on 8/3/2016.
 */
public class EnemyManager extends ControllerManager {

    private int count;
    private static final int RESPAWN_TYPE1 = 100;
    private static final int RESPAWN_TYPE2 = 200;

    private EnemyManager() {
        super();
    }

    @Override
    public void run() {
        super.run();

        count++;

        int enX = 10;
        int enY = 10;

        if(count == RESPAWN_TYPE2) {
            count = 0;
            /* TODO: Generate plane controller 2 */
            for (int i = 0; i < 5; i++) {
                EnemyController enemyController =
                        EnemyController.create(enX,
                                enY, EnemyPlaneType.WHITE);
                enX += 100;
                this.add(enemyController);
            }
        }
        else if (count == RESPAWN_TYPE1) {
            for (int i = 0; i < 5; i++) {
                EnemyController enemyController =
                        EnemyController.create(enX,
                                enY, EnemyPlaneType.YELLOW);
                enX += 100;
                this.add(enemyController);
            }
        }
    }

    public final static EnemyManager instance = new EnemyManager();
}

