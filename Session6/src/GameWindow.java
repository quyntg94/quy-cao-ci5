import Controllers.*;
import Controllers.Bomb.BombControllerManager;
import Controllers.Enemy.EnemyBulletControllerManager;
import Controllers.Enemy.EnemyControllerManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;


/**
 * Created by giaqu on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{

    Image backGround;

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;

    //PlaneController planeController1;

    public GameWindow(){
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(750,600);
        this.setLocation(0,0);

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
        backGround = Utils.loadImage("resources/background.png");

        this.addKeyListener(PlaneController.instance);

        this.bufferedImage = new BufferedImage(800,600,bufferedImage.TYPE_INT_RGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(backGround, 0, 0, null);

        PlaneController.instance.draw(bufferedImageGraphics);
        EnemyControllerManager.instance.draw(bufferedImageGraphics);
        EnemyBulletControllerManager.instance.draw(bufferedImageGraphics);
        BombControllerManager.instance.draw(bufferedImageGraphics);

        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                PlaneController.instance.run();
                EnemyBulletControllerManager.instance.run();
                EnemyControllerManager.instance.run();
                BombControllerManager.instance.run();
                CollisionPool.instance.run();


                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


