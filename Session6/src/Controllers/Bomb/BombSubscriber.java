package Controllers.Bomb;

import Models.GameObject;

/**
 * Created by giaqu on 8/10/2016.
 */
public interface BombSubscriber {
    public void onBombExplode(int x, int y);
    public GameObject getGameObject();
}

