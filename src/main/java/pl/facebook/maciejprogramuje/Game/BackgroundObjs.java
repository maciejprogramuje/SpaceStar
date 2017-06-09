package pl.facebook.maciejprogramuje.Game;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Main.Main;

import java.util.Random;

public class BackgroundObjs extends GameObjects {
    public BackgroundObjs(String objName, AnchorPane gameAnchorPane, int speed) {
        super(gameAnchorPane, objName, speed);

        objImage.setLayoutY(new Random().nextInt(Main.gamePaneHeight - objImage.getHeight().intValue()));
        objImage.setX(new Random().nextInt(Main.gamePaneWidth - objImage.getWidth().intValue()));
    }

    public void moveConditions() {
        if (getObjBorders().getTopBorder() < Main.gamePaneHeight) {
            objImage.setLayoutY(objImage.getLayoutY() + 1);
        } else {
            objImage.setLayoutY(objImage.getHeight() * -1);
            objImage.setX(new Random().nextInt(Main.gamePaneWidth - objImage.getWidth().intValue()));
        }
    }
}

