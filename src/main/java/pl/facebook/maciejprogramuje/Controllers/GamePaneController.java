package pl.facebook.maciejprogramuje.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.PanesObjs.NewGame;
import pl.facebook.maciejprogramuje.PanesObjs.ShowBackground;
import pl.facebook.maciejprogramuje.PanesObjs.ObjUtils.En;
import pl.facebook.maciejprogramuje.PanesObjs.ObjInGame.Rocket;
import pl.facebook.maciejprogramuje.PanesObjs.ObjInGame.SpaceShip;
import pl.facebook.maciejprogramuje.PanesObjs.ShowEnemies;


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

        ShowEnemies showEnemies = new ShowEnemies(gameAnchorPane, 20);

    }
}
