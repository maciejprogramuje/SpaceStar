package pl.facebook.maciejprogramuje.Game.ObjInGame;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.GameObjects;
import pl.facebook.maciejprogramuje.Game.ObjUtils.En;
import pl.facebook.maciejprogramuje.Main.Main;

public class Enemy1 extends GameObjects {
    private double line;

    public Enemy1(AnchorPane gameAnchorPane, String img, int speed) {
        super(gameAnchorPane, img, speed);
    }

    @Override
    public void moveConditions() {
        checkBorderCollisions(getObjBorders().getLeftBorder(), 0, En.Course.RIGHT);
        checkBorderCollisions(getObjBorders().getRightBorder(), Main.gamePaneWidth, En.Course.LEFT);
        checkCollisions();
        move();
    }

    private void checkCollisions() {
        Node rocketToRemove = null;

        for(int i = 0; i <gameAnchorPane.getChildren().size(); i++) {
            Node tempRocket = gameAnchorPane.getChildren().get(i);
            if(tempRocket.lookup("#rocketId") != null) {
                if( tempRocket.getBoundsInParent().getMinY() < getObjBorders().getBottomBorder()
                        && tempRocket.getBoundsInParent().getMinY() > getObjBorders().getTopBorder()
                        && tempRocket.getBoundsInParent().getMinX() > getObjBorders().getLeftBorder()
                        && tempRocket.getBoundsInParent().getMinX() < getObjBorders().getRightBorder()
                        ) {
                    rocketToRemove = tempRocket;
                }
            }
        }

        gameAnchorPane.getChildren().remove(rocketToRemove);
    }

    private void checkBorderCollisions(Double objectBorderVal, Integer borderVal, En.Course direction) {
        if(objectBorderVal.intValue() == borderVal) {
            setCourse(En.Course.DOWN);
            line++;
            if(line == 30) {
                setCourse(direction);
                line = 0;
            }
        }
    }

    private void move() {
        if(course.equals(En.Course.LEFT)) {
            objImage.getImageView().setLayoutX(objImage.getImageView().getLayoutX() - 1);
        } else if (course.equals(En.Course.RIGHT)) {
            objImage.getImageView().setLayoutX(objImage.getImageView().getLayoutX() + 1);
        } else if (course.equals(En.Course.DOWN)) {
            objImage.getImageView().setLayoutY(objImage.getImageView().getLayoutY() + 1);
        }
    }
}
