import Models.Bullet;
import Models.EnemyPlane;
import Models.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by giaqu on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image backGround;
    Image planeImage;
    Image enemyPlaneImage;
    Image extraPlaneImage;
    Image bulletImage;
//    int extraX = 400;
//    int extraY = 300;
//    int planeX = 350;
//    int planeY = 500;
    int extraPlaneWidth;
    int extraPlaneHeight;
    Plane plane;
    Plane extraPlane;
    EnemyPlane enemyPlane;
    //Bullet bullet;

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;

    Vector<Bullet> bulletVector;
    Vector<EnemyPlane> enemyPlaneVector;

    public GameWindow(){
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(750,600);
        this.setLocation(0,0);
        extraPlane =  new Plane(400, 300);
        plane = new Plane(350, 500);
        bulletVector = new Vector<>();
        enemyPlaneVector  = new Vector<>();
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
        try {
            backGround = ImageIO.read(new File("resources/background.png"));
            planeImage = ImageIO.read(new File("resources/plane4.png"));
            enemyPlaneImage = ImageIO.read(new File("resources/plane1.png"));
            extraPlaneImage = ImageIO.read(new File("resources/plane2.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("KeyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("KeyPressed");
                switch (e.getKeyCode()){
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(extraPlane.x, extraPlane.y);
                        bulletVector.add(bullet);
                        break;
                    case KeyEvent.VK_LEFT:
                        plane.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane.y -= 10 ;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane.y += 10;
                        break;

                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("KeyReleased");
            }
        });
        this.bufferedImage = new BufferedImage(800,600,bufferedImage.TYPE_INT_RGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                extraPlane.moveTo(e.getX() - extraPlaneWidth / 2,
                        extraPlane.y =  e.getY() - extraPlaneHeight /2);
            }
        });
    }

    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(backGround, 0, 0, null);
        for(int i = 0; i < bulletVector.size(); i++){
            Bullet bullet =  bulletVector.get(i);
            bufferedImageGraphics.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        bufferedImageGraphics.drawImage(planeImage, plane.x, plane.y, null);
        for (EnemyPlane enemyPlane : enemyPlaneVector) {
            bufferedImageGraphics.drawImage(enemyPlaneImage, enemyPlane.x, enemyPlane.y, null);
        }
        bufferedImageGraphics.drawImage(extraPlaneImage, extraPlane.x, extraPlane.y, null);
        g.drawImage(bufferedImage, 0, 0, null);
        //System.out.println("Update");
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void run() {
        Random rand = new Random();
        int t = 0;
        while (true) {
            try {
                Thread.sleep(27);

                enemyPlaneVector.add(new EnemyPlane(rand.nextInt(600) + 16, 70));

                Iterator<EnemyPlane> enemyPlaneIterator = enemyPlaneVector.iterator();
                while (enemyPlaneIterator.hasNext()) {
                    EnemyPlane enemyPlane = enemyPlaneIterator.next();
                    enemyPlane.y += 1;
                    if (enemyPlane.y > 610) {
                        enemyPlaneIterator.remove();
                        break;
                    }

                Rectangle enemyPlaneRectangle = new Rectangle(enemyPlane.x, enemyPlane.y, enemyPlaneImage.getWidth(null), enemyPlaneImage.getHeight(null));

                Iterator<Bullet> bulletIterator = bulletVector.iterator();
                while (bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    Rectangle bulletRectangle = new Rectangle(bullet.x, bullet.y, bulletImage.getWidth(null), bulletImage.getHeight(null));
                    if (enemyPlaneRectangle.intersects(bulletRectangle)) {
                        enemyPlaneIterator.remove();
                        bulletIterator.remove();
                        break;
                    }
                }
            }


                Iterator<Bullet> bulletIterator1 = bulletVector.iterator();
                while (bulletIterator1.hasNext()) {
                    Bullet bullet = bulletIterator1.next();
                    bullet.y -= 10;
                    if (bullet.y <= 0) {
                            bulletIterator1.remove();
                    }
                }
                repaint();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

