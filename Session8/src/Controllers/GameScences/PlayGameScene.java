package Controllers.GameScences;

import Controllers.*;
import Controllers.Bomb.BombControllerManager;
import Controllers.Enemy.EnemyBulletControllerManager;
import Controllers.Enemy.EnemyControllerManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by giaqu on 8/14/2016.
 */
public class PlayGameScene implements GameScene {

    private Image background;

    private GameSceneListener gameSceneListener;

    public PlayGameScene() {
        background =  Utils.loadImage("resources/background.png");
        reset();
    }

    private void reset() {
        
    }

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        gameSceneListener = gameSceneListener;
        PlaneController.instance.setGameSceneListener(gameSceneListener);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        PlaneController.instance.draw(g);
        EnemyControllerManager.instance.draw(g);
        EnemyBulletControllerManager.instance.draw(g);
        BombControllerManager.instance.draw(g);
        GiftControllerManager.instance.draw(g);
        ProtectControllerManager.instance.draw(g);
    }

    @Override
    public KeyListener getKeyListener() {
        return PlaneController.instance;
    }

    @Override
    public void run() {
        PlaneController.instance.run();
        EnemyBulletControllerManager.instance.run();
        EnemyControllerManager.instance.run();
        BombControllerManager.instance.run();
        GiftControllerManager.instance.run();
        ProtectControllerManager.instance.run();
        CollisionPool.instance.run();
    }
}
