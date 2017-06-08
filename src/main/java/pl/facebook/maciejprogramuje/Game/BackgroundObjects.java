package pl.facebook.maciejprogramuje.Game;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Main.Main;

import java.util.Random;

public class BackgroundObjects extends GameObjects {
    public BackgroundObjects(String objName, AnchorPane gameAnchorPane, int speed) {
        super(gameAnchorPane, objName, speed);

        objImage.getImageView().setLayoutY(new Random().nextInt(Main.gamePaneHeight - objImage.getHeight().intValue()));
        objImage.getImageView().setX(new Random().nextInt(Main.gamePaneWidth - objImage.getWidth().intValue()));
    }

    public void moveConditions() {
        if (getObjBorders().getTopBorder() < Main.gamePaneHeight) {
            objImage.getImageView().setLayoutY(objImage.getImageView().getLayoutY() + 1);
        } else {
            objImage.getImageView().setLayoutY(objImage.getHeight() * -1);
            objImage.getImageView().setX(new Random().nextInt(Main.gamePaneWidth - objImage.getWidth().intValue()));
        }
    }
}

