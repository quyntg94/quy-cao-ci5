package Controllers;

import Controllers.Bomb.NotificationCenter;
import Models.Gift;
import Views.GameDrawer;
import Views.ImageDrawer;

/**
 * Created by giaqu on 8/20/2016.
 */
public class GiftController extends SingleController implements Colliable {

    public GiftController(Gift gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
    }

    public static Controllers.GiftController create(int x, int y) {
        return new Controllers.GiftController(new Gift(x,y), new ImageDrawer("resources/gift.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance.onProtect(
                    gameObject.getX(),
                    gameObject.getY()
            );
            gameObject.destroy();
        }
    }
}
