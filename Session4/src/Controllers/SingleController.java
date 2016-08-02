package Controllers;

import Models.GameObject;
import Models.GameVector;
import Views.GameDrawer;

import java.awt.*;

/**
 * Created by giaqu on 7/30/2016.
 */
public class SingleController implements BaseController {

    private GameDrawer gameDrawer;
    protected GameObject gameObject;
    protected GameVector gameVector;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();
    }

    @Override
    public void draw(Graphics graphics) {
        gameDrawer.draw(graphics, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector);
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
