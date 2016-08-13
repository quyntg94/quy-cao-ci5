package Controllers.Enemy;

import Controllers.Bomb.BombSubscriber;
import Controllers.Bomb.FreezeSubcriber;
import Controllers.Bomb.NotificationCenter;
import Controllers.Colliable;
import Controllers.CollisionPool;
import Controllers.SingleController;
import Models.Enemy;
import Views.GameDrawer;
import Views.ImageDrawer;

/**
 * Created by giaqu on 8/3/2016.
 */

public class EnemyController extends
        SingleController implements
        Colliable, BombSubscriber, FreezeSubcriber {

    public static final int SPEED = 3;
    private EnemyState enemyState;
    private int frezzeCount;

    private int FREZZE_PERIOD = 200;

    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private FlyBehavior flyBehavior;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,
                           FreezeBehavior freezeBehavior,
                           ShotBehavior shotBehavior,
                           FlyBehavior flyBehavior) {
        super(gameObject, gameDrawer);

        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
        NotificationCenter.instance
                .subsribe(this);
        NotificationCenter.instance
                .subsribeFrezze(this);
        enemyState = EnemyState.NORMAL;
        this.freezeBehavior = freezeBehavior;
        this.shotBehavior = shotBehavior;
        this.flyBehavior = flyBehavior;
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new FreezeBehavior(200),
                        new StraightShotBehavior(),
                        new CrossFlyBehavior());
                break;
            case WHITE:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new FreezeBehavior(300),
                        new FollowShotBehavior(),
                        new ZicZacFlyBehavior());
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }

    @Override
    public void run() {

        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZZED:
                break;
        }

        if (freezeBehavior != null)
            freezeBehavior.run(this);
        if(shotBehavior != null)
            shotBehavior.doShot(this);
        if(flyBehavior != null)
            flyBehavior.doFly(this);
    }


    @Override
    public void onFrezze(int x, int y) {
        enemyState = EnemyState.FREZZED;
        frezzeCount = 0;
    }
}



