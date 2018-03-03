package pigeonsquare;

import pigeonsquare.utils.Position;

public class Food extends Item {
    private static final String assetPath = "assets/seed.png";
    private boolean isFresh;

    public Food(Position position) {
        this.position = position;
        this.isFresh = true;
        this.loadImage(assetPath);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            this.isFresh = false;
            Thread.sleep(2000);
            Environment.getInstance().removeFood(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
