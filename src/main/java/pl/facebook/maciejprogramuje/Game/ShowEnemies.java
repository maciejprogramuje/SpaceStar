package pl.facebook.maciejprogramuje.Game;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ObjInGame.Enemy1;

public class ShowEnemies {
    public ShowEnemies(AnchorPane gameAnchorPane) {
        Enemy1 enemy1 = new Enemy1(gameAnchorPane, 20);
        enemy1.play();
    }
}
