package pl.facebook.maciejprogramuje.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ShowBackground;
import pl.facebook.maciejprogramuje.Game.ObjUtils.En;
import pl.facebook.maciejprogramuje.Game.ObjInGame.Rocket;
import pl.facebook.maciejprogramuje.Game.ObjInGame.SpaceShip;
import pl.facebook.maciejprogramuje.Game.ShowEnemies;


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
        new ShowBackground(gameAnchorPane);

        spaceShip = new SpaceShip(gameAnchorPane, "ship", 5);
        spaceShip.play();

        new ShowEnemies(gameAnchorPane);
    }
}
