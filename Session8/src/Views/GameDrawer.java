package Views;

import Models.GameObject;

import java.awt.*;

/**
 * Created by giaqu on 7/30/2016.
 */
public interface GameDrawer {
    void run();
    void draw(Graphics graphics, GameObject gameObject);
}
