package pigeonsquare;

import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

/**
 * Food class
 */
public class Food extends Item {
    private boolean isFresh;

    /**
     * Constructor
     * @param position The initial position
     */
    Food(Position position) {
        this.position = position;
        this.isFresh = true;
        this.loadImage(Constants.PATH_GOOD_SEED);
    }

    /**
     * Life cycle of a food item
     * Fresh for a few seconds, stale for a few seconds then disappears
     */
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

    /**
     * Check if the food is fresh
     * @return A boolean
     */
    public boolean isFresh() {
        return isFresh;
    }
}
