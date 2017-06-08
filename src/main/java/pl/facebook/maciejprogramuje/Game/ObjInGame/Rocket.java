package pl.facebook.maciejprogramuje.Game.ObjInGame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.GameObjects;

import java.util.ArrayList;

public class Rocket extends GameObjects {
    public Rocket(AnchorPane gameAnchorPane, String img, int speed, SpaceShip spaceShip) {
        super(gameAnchorPane, img, speed);

        objImage.getImageView().setId("rocketId");

        objImage.getImageView().setY(spaceShip.getObjBorders().getTopBorder() - objImage.getWidth());
        objImage.getImageView().setX(spaceShip.getObjBorders().getLeftBorder() + spaceShip.getObjImage().getWidth() / 2 - objImage.getWidth() / 2);
    }

    @Override
    public void moveConditions() {
        if(this.getObjBorders().getTopBorder() > 0) {
            objImage.getImageView().setLayoutY(objImage.getImageView().getLayoutY() - 1);
        } else {
            gameAnchorPane.getChildren().remove(objImage.getImageView());
        }
    }
}
