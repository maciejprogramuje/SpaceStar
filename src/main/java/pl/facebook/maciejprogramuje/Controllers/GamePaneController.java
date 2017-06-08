package pl.facebook.maciejprogramuje.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.Background;
import pl.facebook.maciejprogramuje.Game.GameObjects;
import pl.facebook.maciejprogramuje.Game.ObjInGame.Enemy1;
import pl.facebook.maciejprogramuje.Game.ObjUtils.En;
import pl.facebook.maciejprogramuje.Game.ObjInGame.Rocket;
import pl.facebook.maciejprogramuje.Game.ObjInGame.SpaceShip;
import pl.facebook.maciejprogramuje.Game.ShowEnemies;

import java.util.ArrayList;


public class GamePaneController {
    @FXML
    public AnchorPane gameAnchorPane;

    private SpaceShip spaceShip;

    public void initialize() {
        resetGameToDefaultSettings();

        gameAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.LEFT) {
                spaceShip.setOldCourse(spaceShip.getCourse());
                spaceShip.setCourse(En.Course.LEFT);
            } else if (event.getCode() == KeyCode.RIGHT) {
                spaceShip.setOldCourse(spaceShip.getCourse());
                spaceShip.setCourse(En.Course.RIGHT);
            } else if (event.getCode() == KeyCode.SPACE) {
                Rocket rocket = new Rocket(gameAnchorPane, "rocket1", 5, spaceShip);
                rocket.play();
            }
        });
    }

    private void resetGameToDefaultSettings() {
        new Background(gameAnchorPane);

        spaceShip = new SpaceShip(gameAnchorPane, "ship", 5);
        spaceShip.play();

        new ShowEnemies(gameAnchorPane);
    }
}
