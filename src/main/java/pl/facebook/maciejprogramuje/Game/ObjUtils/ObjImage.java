package pl.facebook.maciejprogramuje.Game.ObjUtils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObjImage extends ImageView{
    private String name;
    private Double width, height;

    public ObjImage(String name) {
        this.name = name;
        Image image = new Image("/img/" + name + ".png");
        width = image.getWidth();
        height = image.getHeight();
        this.setImage(image);
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }
}
