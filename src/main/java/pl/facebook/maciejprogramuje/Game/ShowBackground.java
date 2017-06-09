package pl.facebook.maciejprogramuje.Game;

import javafx.scene.layout.AnchorPane;
import pl.facebook.maciejprogramuje.Game.ObjOnBckgrnd.*;

import java.util.ArrayList;
import java.util.Random;

public class ShowBackground {
    private int numberOfDust1 = 20;
    private int numberOfDust2 = 20;
    private int numberOfStars = 20;
    private int numberOfPlanets1 = 2;
    private int numberOfPlanets2 = 1;

    public ShowBackground(AnchorPane gameAnchorPane) {
        ArrayList<BackgroundObjs> backgroundObjsArray = new ArrayList<>();

        for(int i = 0; i < numberOfDust2; i++) {
            BackgroundObjs dust2 = new Dust2(gameAnchorPane, new Random().nextInt(40) + 38);
            dust2.play();
            backgroundObjsArray.add(dust2);
        }

        for(int i = 0; i < numberOfDust1; i++) {
            BackgroundObjs dust1 = new Dust1(gameAnchorPane, new Random().nextInt(40) + 38);
            dust1.play();
            backgroundObjsArray.add(dust1);
        }

        for(int i = 0; i < numberOfStars; i++) {
            BackgroundObjs star = new Star(gameAnchorPane, new Random().nextInt(35) + 31);
            star.play();
            backgroundObjsArray.add(star);
        }

        for(int i = 0; i < numberOfPlanets1; i++) {
            BackgroundObjs planet1 = new Planet1(gameAnchorPane, new Random().nextInt(31) + 29);
            planet1.play();
            backgroundObjsArray.add(planet1);
        }

        for(int i = 0; i < numberOfPlanets2; i++) {
            BackgroundObjs planet2 = new Planet2(gameAnchorPane, new Random().nextInt(30) + 30);
            planet2.play();
            backgroundObjsArray.add(planet2);
        }
    }
}
