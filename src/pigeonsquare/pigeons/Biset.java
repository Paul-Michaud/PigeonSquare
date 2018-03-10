package pigeonsquare.pigeons;

import pigeonsquare.utils.Position;

public class Biset extends Pigeon {
    private static final String assetPath = "assets/biset.png";

    public Biset(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
