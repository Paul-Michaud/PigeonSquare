package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Biset extends Pigeon {
    private static final String assetPath = Constants.PATH_BISET;

    public Biset(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
