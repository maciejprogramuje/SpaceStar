package pl.facebook.maciejprogramuje.Game.ObjInGame;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.GameObjects;
import pl.facebook.maciejprogramuje.Game.ObjUtils.En;
import pl.facebook.maciejprogramuje.Main.Main;

public class SpaceShip extends GameObjects {
    private En.Course oldCourse;

    public SpaceShip(AnchorPane gameAnchorPane, String img, int speed) {
        super(gameAnchorPane, img, speed);

        oldCourse = En.Course.NEUTRAL;

        objImage.getImageView().setY(gameAnchorPane.getPrefHeight() - objImage.getHeight() - 20);
        objImage.getImageView().setX(gameAnchorPane.getPrefWidth() / 2 - objImage.getWidth() / 2);
    }

    @Override
    public void moveConditions() {
        if(oldCourse.equals(En.Course.NEUTRAL)) {
            if (course.equals(En.Course.LEFT) && getObjBorders().getLeftBorder() > 0) {
                objImage.getImageView().setLayoutX(objImage.getImageView().getLayoutX() - 1);
            } else if (course.equals(En.Course.RIGHT) && getObjBorders().getRightBorder() < Main.gamePaneWidth) {
                objImage.getImageView().setLayoutX(objImage.getImageView().getLayoutX() + 1);
            } else {
                this.setCourse(En.Course.NEUTRAL);
            }
        } else {
            this.setCourse(En.Course.NEUTRAL);
        }

        changeShipImage();
    }

    private void changeShipImage() {
        if (course.equals(En.Course.LEFT) && !objImage.getImageView().getImage().equals(new Image("/img/shipL.png"))) {
            objImage.getImageView().setImage(new Image("/img/shipL.png"));
        } else if (course.equals(En.Course.RIGHT) && !objImage.getImageView().getImage().equals(new Image("/img/shipR.png"))) {
            objImage.getImageView().setImage(new Image("/img/shipR.png"));
        } else if (course.equals(En.Course.NEUTRAL) && !objImage.getImageView().getImage().equals(new Image("/img/ship.png"))) {
            objImage.getImageView().setImage(new Image("/img/ship.png"));
        }
    }

    public void setOldCourse(En.Course oldCourse) {
        this.oldCourse = oldCourse;
    }


}
