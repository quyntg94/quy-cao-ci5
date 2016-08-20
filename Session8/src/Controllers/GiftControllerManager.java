package Controllers;

import java.util.Random;

/**
 * Created by giaqu on 8/20/2016.
 */
public class GiftControllerManager extends ControllerManager {

    private int count;
    private static final int GIFT_PERIOD = 200;

    public static final Controllers.GiftControllerManager instance = new Controllers.GiftControllerManager();

    @Override
    public void run() {
        count++;

        Random r = new Random();
        int x = r.nextInt(600);
        int y = r.nextInt(800);

        if(count >= GIFT_PERIOD) {
            count = 0;
            GiftController giftController = GiftController
                    .create(x, y);
            this.add(giftController);
        }
        super.run();
    }
}
