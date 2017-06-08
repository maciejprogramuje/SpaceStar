package pl.facebook.maciejprogramuje.Game;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ObjInGame.Enemy1;

public class ShowEnemies {
    public ShowEnemies(AnchorPane gameAnchorPane) {
        GameObjects enemy1 = new Enemy1(gameAnchorPane, "enemy1", 10);
        enemy1.play();
    }
}
