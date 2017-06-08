package pl.facebook.maciejprogramuje.Game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import pl.facebook.maciejprogramuje.Game.ObjUtils.*;

public abstract class GameObjects {
    protected AnchorPane gameAnchorPane;
    protected ObjImage objImage;
    private ObjBorders objBorders;
    private ObjCollision objCollision;
    protected En.Course course;
    private Timeline animation;

    public GameObjects(AnchorPane gameAnchorPane, String img, int speed) {
        this.gameAnchorPane = gameAnchorPane;
        objImage = new ObjImage(img);
        setObjBorders(new ObjBorders());
        objCollision = new ObjCollision();
        course = En.Course.NEUTRAL;

        setAnimationTimeline(speed);

        gameAnchorPane.getChildren().add(objImage.getImageView());
    }

    private void setAnimationTimeline(int speed) {
        objImage.getImageView().setFocusTraversable(true);

        animation = new Timeline();

        animation.setCycleCount(Animation.INDEFINITE);
        Duration duration = Duration.millis(speed);

        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setObjBorders(getObjBorders(), objImage);
                moveConditions();
            }
        };
        KeyFrame keyFrame = new KeyFrame(duration, onFinished);

        animation.getKeyFrames().add(keyFrame);
    }

    public abstract void moveConditions();

    private void setObjBorders(ObjBorders objBorders, ObjImage objImage) {
        objBorders.setTopBorder(objImage.getImageView().getY() + objImage.getImageView().getLayoutY());
        objBorders.setLeftBorder(objImage.getImageView().getX() + objImage.getImageView().getLayoutX());
        objBorders.setBottomBorder(objBorders.getTopBorder() + objImage.getHeight());
        objBorders.setRightBorder(objBorders.getLeftBorder() + objImage.getWidth());
    }

    public void play() {
        animation.play();
    }

    public void stop() {
        animation.stop();
    }

    public void setCourse(En.Course course) {
        this.course = course;
    }

    public En.Course getCourse() {
        return course;
    }

    public ObjBorders getObjBorders() {
        return objBorders;
    }

    private void setObjBorders(ObjBorders objBorders) {
        this.objBorders = objBorders;
    }

    public ObjImage getObjImage() {
        return objImage;
    }

    public void setObjImage(ObjImage objImage) {
        this.objImage = objImage;
    }
}
