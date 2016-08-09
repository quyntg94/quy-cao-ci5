package Controllers;

import Models.Enemy;
import Views.ImageDrawer;

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
        int enX = 10;
        int enY = 10;
        count++;
        if(count >= RESPAWN_TYPE2){
            for(int i = 0; i < 5; i++) {
                EnemyController2 enemyController2 = new EnemyController2(
                        new Enemy(enX, enY),
                        new ImageDrawer("resources/enemy_plane_white_3.png")
                );
                enX += 100;
                this.add(enemyController2);
            }
        }
        else if(count >= RESPAWN_TYPE1){
            for(int i = 0; i < 5; i++) {
                EnemyController enemyController = new EnemyController(
                        new Enemy(enX, enY),
                        new ImageDrawer("resources/enemy_plane_white_3.png")
                );
                enX += 100;
                this.add(enemyController);
            }
        }
    }

    public final static EnemyManager instance = new EnemyManager();
}
