package Controllers;

import Models.Bomb;
import Views.ImageDrawer;

import java.util.Random;

/**
 * Created by giaqu on 8/6/2016.
 */
public class BombControllerManager extends ControllerManager{

    private Random rand = new Random();
    private static int countBlack = 0;
    private static int countBlue = 0;
    private static final int B = 1000;
    private static final int A = 500;


    private BombControllerManager(){

        super();
    }

    @Override
    public void run() {
        super.run();
        countBlack++;
        countBlue++;
        int enX = rand.nextInt(700) ;
        int enY = rand.nextInt(200) ;
        if(countBlack == B){
            countBlack = 0;
            for (int i = 0; i < 1; i++) {

                BombControllerBlack bombControllerBlack = new BombControllerBlack(
                        new Bomb(enX, enY),
                        new ImageDrawer("resources/bomb.png")
                );
                this.add(bombControllerBlack);

            }
        }
        else if(countBlue == A){
                countBlue = 0;
                for (int i = 0; i < 1; i++) {

                    BombControllerBlue bombControllerBlue = new BombControllerBlue(
                            new Bomb(enX, enY),
                            new ImageDrawer("resources/shit.png")
                    );
                    this.add(bombControllerBlue);

                }
        }
    }

    public final static BombControllerManager instance = new BombControllerManager();

}
