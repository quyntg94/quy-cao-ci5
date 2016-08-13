package Views;

import Models.GameObject;
import Utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;

/**
 * Created by giaqu on 7/30/2016.
 */
public class ImageDrawer implements GameDrawer{

    private Image image;

    public ImageDrawer(Image image) {
        this.image = image;
    }

    public ImageDrawer(String url){
        this.image = Utils.loadImage(url);
    }
    @Override
    public void draw(Graphics graphics, GameObject gameObject) {
        graphics.drawImage(image, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(), null);
    }



}
