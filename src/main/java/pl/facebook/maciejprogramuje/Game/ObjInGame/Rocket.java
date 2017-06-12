package pl.facebook.maciejprogramuje.PanesObjs.ObjInGame;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.PanesObjs.GameObjs;

public class Rocket extends GameObjs {
    public Rocket(AnchorPane gameAnchorPane, String img, int speed, SpaceShip spaceShip) {
        super(gameAnchorPane, img, speed);

        objImage.setId("rocketId");

        objImage.setY(spaceShip.getObjBorders().getTopBorder() - objImage.getWidth());
        objImage.setX(spaceShip.getObjBorders().getLeftBorder() + spaceShip.getObjImage().getWidth() / 2 - objImage.getWidth() / 2);
    }

    @Override
    public void moveConditions() {
        if(this.getObjBorders().getTopBorder() > 0) {
            objImage.setLayoutY(objImage.getLayoutY() - 1);
        } else {
            gameAnchorPane.getChildren().remove(objImage);
        }
    }
}
