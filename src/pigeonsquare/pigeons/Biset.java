package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

/**
 * Biset pigeon
 */
public class Biset extends Pigeon {
    public Biset(Position position) {
        this.position = position;
        this.loadImage(Constants.PATH_BISET);
    }
}
