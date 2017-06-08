package pl.facebook.maciejprogramuje.Controllers;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartPaneController {
    public Button yesButton;
    public Button noButton;

    public void initialize() {
        noButton.setOnAction(event -> Platform.exit());
    }
}
