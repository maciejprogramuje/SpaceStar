package pl.facebook.maciejprogramuje.Utils;

import javafx.scene.control.Alert;

public class Alerts {
    public static void showAlert(Exception e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
    }
}
