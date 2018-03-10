package pigeonsquare;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Food extends Item {
    private static final String goodSeed = Constants.PATH_GOOD_SEED;
    private static final String badSeed = Constants.PATH_BAD_SEED;

    private boolean isFresh;
    Food(Position position) {
        this.position = position;
        this.isFresh = true;
        this.loadImage(goodSeed);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Constants.FRESH_TIME);
            this.isFresh = false;
            this.changeImage(badSeed);
            Thread.sleep(Constants.STALE_TIME);
            Environment.getInstance().removeItem(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFresh() {
        return isFresh;
    }

}
