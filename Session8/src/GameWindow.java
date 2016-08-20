import Controllers.GameScences.GameScene;
import Controllers.GameScences.GameSceneListener;
import Controllers.GameScences.MenuGameScence;
import Models.GameSetting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;


/**
 * Created by giaqu on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener{

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    GameSetting gameSetting;
    Thread thread;

    private Stack<GameScene> stack;

    GameScene currentGameScene;

    public GameWindow() {
        configUI();
        stack = new Stack<GameScene>();
        changeGameScene(new MenuGameScence(), false);

        this.bufferedImage = new BufferedImage(gameSetting.getScreenWidth(),
                gameSetting.getScreenHeight(),
                BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    GameWindow.this.back();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            private void back() {

            }
        });
    }

    private void configUI() {

        gameSetting = GameSetting.getInstance();
        this.setVisible(true);
        this.setSize(gameSetting.getScreenWidth(), gameSetting.getScreenHeight());;
        this.setLocation(0, 0);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        this.currentGameScene.draw(bufferedImageGraphics);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.currentGameScene.run();
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScene(GameScene gameScene, boolean addToStack) {
        if(currentGameScene != null && addToStack) {
            this.removeKeyListener(currentGameScene.getKeyListener());
            this.stack.push(currentGameScene);
        }
        currentGameScene = gameScene;
        currentGameScene.setGameSceneListener(this);
        this.addKeyListener(currentGameScene.getKeyListener());
    }

    @Override
    public void back() {
        if(!stack.isEmpty()) {
            this.removeKeyListener(currentGameScene.getKeyListener());
            currentGameScene = stack.pop();
            currentGameScene.setGameSceneListener(this);
            this.addKeyListener(currentGameScene.getKeyListener());
        } else {
            //System.exit(0);
        }
    }
}


