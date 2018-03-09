package pigeonsquare;

import pigeonsquare.utils.Position;

public class Food extends Item {
    private static final String goodSeed = "assets/seed.png";
    private static final String badSeed = "assets/bad_seed.png";

    private boolean isFresh;
    Food(Position position) {
        this.position = position;
        this.isFresh = true;
        this.loadImage(goodSeed);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            this.isFresh = false;
            this.changeImage(badSeed);
            Thread.sleep(2000);
            Environment.getInstance().removeItem(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFresh() {
        return isFresh;
    }

}
