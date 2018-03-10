package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Ramier extends Pigeon {
    private static final String assetPath = Constants.PATH_RAMIER;

    public Ramier(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
