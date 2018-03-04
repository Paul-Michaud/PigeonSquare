package pigeonsquare.pigeons;

import com.sun.javafx.geom.Vec2d;

public class Ramier extends Pigeon {
    private static final String assetPath = "assets/pigeon.png";

    public Ramier(Vec2d position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
