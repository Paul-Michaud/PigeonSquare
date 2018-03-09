package pigeonsquare.pigeons;

import pigeonsquare.utils.Position;

public class Colombin extends Pigeon {
    private static final String assetPath = "assets/pigeon.png";

    public Colombin(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
