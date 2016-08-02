package Controllers;

import Models.GameObject;

/**
 * Created by giaqu on 7/31/2016.
 */
public interface Colliable {

    GameObject getGameObject();

    void onCollide(Colliable colliable);
}
