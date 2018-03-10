package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Ramier extends Pigeon {
    public Ramier(Position position) {
        this.position = position;
        this.loadImage(Constants.PATH_RAMIER);
    }
}
