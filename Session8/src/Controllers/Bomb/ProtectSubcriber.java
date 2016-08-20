package Controllers.Bomb;

import Models.GameObject;

/**
 * Created by giaqu on 8/20/2016.
 */
public interface ProtectSubcriber {
    void onProtect(int x, int y);
    GameObject getGameObject();
}
