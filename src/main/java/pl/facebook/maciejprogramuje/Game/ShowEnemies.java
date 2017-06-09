package pl.facebook.maciejprogramuje.Game;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ObjInGame.Enemy1;

import java.util.ArrayList;

public class ShowEnemies {
    int numberOfEnemies1 = 20;
    ArrayList<Enemy1> enemy1s = new ArrayList<>();

    public ShowEnemies(AnchorPane gameAnchorPane) {
        for(int i = 0; i < numberOfEnemies1; i++) {
            enemy1s.add(new Enemy1(gameAnchorPane, 20));
        }

        for(int i = 0; i < numberOfEnemies1 - 1; i++) {
            Enemy1 tempEnemy1 = enemy1s.get(i + 1);

            enemy1s.get(i).nextPleaseProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    tempEnemy1.play();
                }
            });
        }

        enemy1s.get(0).play();
    }
}
