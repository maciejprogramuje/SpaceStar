package pl.facebook.maciejprogramuje.Game;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ObjUtils.En;
import pl.facebook.maciejprogramuje.Main.Main;

/**
 * Created by m.szymczyk on 2017-06-09.
 */
public class EnemiesObjs extends GameObjects {
    private double line;

    public EnemiesObjs(AnchorPane gameAnchorPane, String img, int speed) {
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

        if(rocketToRemove != null) {
            this.stop();
            gameAnchorPane.getChildren().remove(objImage);
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
            objImage.setLayoutX(objImage.getLayoutX() - 1);
        } else if (course.equals(En.Course.RIGHT)) {
            objImage.setLayoutX(objImage.getLayoutX() + 1);
        } else if (course.equals(En.Course.DOWN)) {
            objImage.setLayoutY(objImage.getLayoutY() + 1);
        }
    }
}
