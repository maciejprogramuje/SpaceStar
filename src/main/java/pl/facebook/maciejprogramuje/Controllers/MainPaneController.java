package pl.facebook.maciejprogramuje.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainPaneController {
    @FXML
    public BorderPane mainBorderPane;

    public void initialize() {
        try {
            FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/fxml/startPane.fxml"));
            Node startGamePaneLoaded = startLoader.load();

            StartPaneController startPaneController = startLoader.getController();
            mainBorderPane.setCenter(startGamePaneLoaded);

            startPaneController.yesButton.setOnAction(event -> {
                FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/fxml/gamePane.fxml"));
                Node gamePaneLoaded = null;
                try {
                    gamePaneLoaded = gameLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mainBorderPane.setCenter(gamePaneLoaded);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
