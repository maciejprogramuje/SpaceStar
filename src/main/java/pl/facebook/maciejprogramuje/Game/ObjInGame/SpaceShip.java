package pl.facebook.maciejprogramuje.PanesObjs.ObjInGame;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.PanesObjs.GameObjs;
import pl.facebook.maciejprogramuje.PanesObjs.ObjUtils.En;
import pl.facebook.maciejprogramuje.Main.Main;

public class SpaceShip extends GameObjs {
    private En.Course oldCourse;

    public SpaceShip(AnchorPane gameAnchorPane, String img, int speed) {
        super(gameAnchorPane, img, speed);

        oldCourse = En.Course.NEUTRAL;

        objImage.setY(gameAnchorPane.getPrefHeight() - objImage.getHeight() - 20);
        objImage.setX(gameAnchorPane.getPrefWidth() / 2 - objImage.getWidth() / 2);
    }

    @Override
    public void moveConditions() {
        if(oldCourse.equals(En.Course.NEUTRAL)) {
            if (course.equals(En.Course.LEFT) && getObjBorders().getLeftBorder() > 0) {
                objImage.setLayoutX(objImage.getLayoutX() - 1);
            } else if (course.equals(En.Course.RIGHT) && getObjBorders().getRightBorder() < Main.gamePaneWidth) {
                objImage.setLayoutX(objImage.getLayoutX() + 1);
            } else {
                this.setCourse(En.Course.NEUTRAL);
            }
        } else {
            this.setCourse(En.Course.NEUTRAL);
        }

        changeShipImage();
    }

    private void changeShipImage() {
        if (course.equals(En.Course.LEFT) && !objImage.getImage().equals(new Image("/img/shipL.png"))) {
            objImage.setImage(new Image("/img/shipL.png"));
        } else if (course.equals(En.Course.RIGHT) && !objImage.getImage().equals(new Image("/img/shipR.png"))) {
            objImage.setImage(new Image("/img/shipR.png"));
        } else if (course.equals(En.Course.NEUTRAL) && !objImage.getImage().equals(new Image("/img/ship.png"))) {
            objImage.setImage(new Image("/img/ship.png"));
        }
    }

    public void setOldCourse(En.Course oldCourse) {
        this.oldCourse = oldCourse;
    }


}
