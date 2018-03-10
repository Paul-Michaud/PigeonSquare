package pigeonsquare.pigeons;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Colombin extends Pigeon {
    public Colombin(Position position) {
        this.position = position;
        this.loadImage(Constants.PATH_COLOMBIN);
    }
}
