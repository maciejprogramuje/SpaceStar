package pl.facebook.maciejprogramuje.Game;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ObjUtils.En;
import pl.facebook.maciejprogramuje.Main.Main;

/**
 * Created by m.szymczyk on 2017-06-09.
 */
public class EnemiesObjs extends GameObjects {
    private double line;
    private BooleanProperty nextPlease = new SimpleBooleanProperty();

    public EnemiesObjs(AnchorPane gameAnchorPane, String img, int speed) {
        super(gameAnchorPane, img, speed);
    }

    @Override
    public void moveConditions() {
        checkNextEnemy();
        checkBorderCollisions(getObjBorders().getLeftBorder(), 0, En.Course.RIGHT);
        checkBorderCollisions(getObjBorders().getRightBorder(), Main.gamePaneWidth, En.Course.LEFT);
        checkRocketCollisions();
        move();
    }

    private void checkNextEnemy() {
        if(this.getObjBorders().getTopBorder() == 0 && this.getObjBorders().getLeftBorder() == 50) {
            nextPlease.set(true);
            this.objImage.setOpacity(1);
        } else {
            this.objImage.setOpacity(this.objImage.getOpacity() + 0.02);
            //this.objImage.setScaleX(this.objImage.getScaleX() + 0.02);
            //this.objImage.setScaleY(this.objImage.getScaleY() + 0.02);

        }
    }

    private void checkRocketCollisions() {
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

        if(rocketToRemove != null && nextPlease.get()) {
            this.stop();
            gameAnchorPane.getChildren().remove(objImage);
        }
        gameAnchorPane.getChildren().remove(rocketToRemove);
    }

    private void checkBorderCollisions(Double objectBorderVal, Integer borderVal, En.Course direction) {
        if(objectBorderVal.intValue() == borderVal) {
            setCourse(En.Course.DOWN);
            line++;
            if(line == 30 + 1) {
                setCourse(direction);
                line = 0;
            }
        }
    }

    private void move() {
        if(course.equals(En.Course.LEFT)) {
            objImage.setLayoutX(objImage.getLayoutX() - 1);
        } else if (course.equals(En.Course.RIGHT)) {
            objImage.setLayoutX(objImage.getLayoutX() + 1);
        } else if (course.equals(En.Course.DOWN)) {
            objImage.setLayoutY(objImage.getLayoutY() + 1);
        }
    }

    protected BooleanProperty nextPleaseProperty() {
        return nextPlease;
    }
}
