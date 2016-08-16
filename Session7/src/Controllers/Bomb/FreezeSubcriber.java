package Controllers.Bomb;


import Models.GameObject;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public interface FreezeSubcriber {
    void onFrezze(int x, int y);
    GameObject getGameObject();
}
