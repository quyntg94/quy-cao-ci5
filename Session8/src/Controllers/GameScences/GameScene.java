package Controllers.GameScences;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by giaqu on 8/14/2016.
 */
public interface GameScene extends Runnable {
    void draw(Graphics g);
    KeyListener getKeyListener();
    void setGameSceneListener(GameSceneListener gameSceneListener);
}
