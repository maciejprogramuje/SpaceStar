package pl.facebook.maciejprogramuje.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import pl.facebook.maciejprogramuje.Utils.Alerts;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainPaneController {
    @FXML
    public BorderPane mainBorderPane;

    public void initialize() {
        try {
            FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/fxml/startPane.fxml"));
            FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/fxml/gamePane.fxml"));

            Node startGamePaneLoaded = startLoader.load();
            Node gamePaneLoaded = gameLoader.load();

            StartPaneController startPaneController = startLoader.getController();
            GamePaneController gamePaneController = gameLoader.getController();

            mainBorderPane.setCenter(startGamePaneLoaded);

            startPaneController.yesButton.setOnAction(event -> {
                try {
                    mainBorderPane.setCenter(gamePaneLoaded);
                } catch (Exception e) {
                    Alerts.showAlert(e);
                }
            });
        } catch (IOException e) {
            Alerts.showAlert(e);
        }
    }
}
