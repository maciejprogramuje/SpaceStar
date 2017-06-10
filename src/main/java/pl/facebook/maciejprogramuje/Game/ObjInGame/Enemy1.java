package pl.facebook.maciejprogramuje.Game.ObjInGame;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.EnemiesObjs;

public class Enemy1 extends EnemiesObjs {
    public Enemy1(AnchorPane gameAnchorPane, int speed) {
        super(gameAnchorPane, "enemy1", speed);

        this.objImage.setY(-30);
        this.objImage.setOpacity(0.2);
        this.objImage.setScaleX(0.2);
        this.objImage.setScaleY(0.2);
    }
}
