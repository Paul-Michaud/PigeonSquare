package pigeonsquare;

import pigeonsquare.utils.Position;

public class Food extends Item {
    private static final String assetPath = "assets/seed.png";
    private boolean isFresh;

    Food(Position position) {
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
            Environment.getInstance().removeItem(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFresh() {
        return isFresh;
    }



}
