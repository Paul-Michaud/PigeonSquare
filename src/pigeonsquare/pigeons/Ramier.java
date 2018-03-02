package pigeonsquare.pigeons;

import pigeonsquare.utils.Position;

public class Ramier extends Pigeon {
    private static final String assetPath = "assets/pigeon.png";

    public Ramier(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
