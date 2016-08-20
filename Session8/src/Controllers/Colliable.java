package Controllers;

import Models.GameObject;

/**
 * Created by giaqu on 8/3/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);

}
