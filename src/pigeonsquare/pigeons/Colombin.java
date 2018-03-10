package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Colombin extends Pigeon {
    private static final String assetPath = Constants.PATH_COLOMBIN;

    public Colombin(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
