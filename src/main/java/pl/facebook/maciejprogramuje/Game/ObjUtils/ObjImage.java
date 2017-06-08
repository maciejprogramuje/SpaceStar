package pl.facebook.maciejprogramuje.Game.ObjUtils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObjImage {
    private String name;
    private ImageView imageView;
    private Double width, height;

    public ObjImage(String name) {
        this.name = name;
        Image image = new Image("/img/" + name + ".png");
        width = image.getWidth();
        height = image.getHeight();
        imageView = new ImageView(image);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }
}
