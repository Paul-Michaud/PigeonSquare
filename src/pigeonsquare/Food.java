package pigeonsquare;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Food extends Item {
    private boolean isFresh;

    Food(Position position) {
        this.position = position;
        this.isFresh = true;
        this.loadImage(Constants.PATH_GOOD_SEED);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Constants.FRESH_TIME);
            this.isFresh = false;
            this.changeImage(Constants.PATH_BAD_SEED);
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
