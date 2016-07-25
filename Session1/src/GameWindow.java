import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by giaqu on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image backGround;
    Image planeImage;
    Image enemyImage;
    Image extraPlaneImage;
    int extraX = 400;
    int extraY = 300;
    int planeX = 350;
    int planeY = 500;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;

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
        try {
            backGround = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            planeImage = ImageIO.read(new File("resources/plane4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            enemyImage = ImageIO.read(new File("resources/plane1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            extraPlaneImage = ImageIO.read(new File("resources/plane2.png"));
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
                    case KeyEvent.VK_LEFT:
                        planeX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX += 10;
                        break;
                    case KeyEvent.VK_UP:
                        planeY -=10;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY +=10;
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
                extraX = e.getX() - 16;
                extraY = e.getY() - 16;
            }
        });
    }

    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(backGround, 0, 0, null);
        bufferedImageGraphics.drawImage(planeImage, planeX, planeY, null);
        bufferedImageGraphics.drawImage(extraPlaneImage, extraX, extraY,null);
        bufferedImageGraphics.drawImage(enemyImage,350,100,null);
        bufferedImageGraphics.drawImage(enemyImage,250,100,null);
        bufferedImageGraphics.drawImage(enemyImage,450,100,null);
        g.drawImage(bufferedImage, 0, 0, null);
        //System.out.println("Update");
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(27);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//thêm máy bay số 2 điều khiển bằng chuột