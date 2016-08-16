package Controllers.GameScences;

import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by giaqu on 8/17/2016.
 */
public class GameOverGameScence implements GameScene, KeyListener{

    private GameSceneListener gameSceneListener;
    private Image background;

    public GameOverGameScence() {
        background = Utils.loadImage("resources/gameover.jpg");
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        /*TODO: Draw game over */
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public void run() {
        /*TODO: Run menu */
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
