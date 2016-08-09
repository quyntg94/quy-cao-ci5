package Controllers;

import Models.Bomb;
import Views.GameDrawer;

/**
 * Created by giaqu on 8/9/2016.
 */
public class BombControllerBlue extends BombControllerBlack implements Colliable {

    public BombControllerBlue(Bomb gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.radius = 200;
    }
}
