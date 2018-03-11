package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

/**
 * Colombin pigeon
 */
public class Colombin extends Pigeon {
    public Colombin(Position position) {
        this.position = position;
        this.loadImage(Constants.PATH_COLOMBIN);
    }
}
