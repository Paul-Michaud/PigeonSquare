package pigeonsquare;

import com.sun.javafx.geom.Vec2d;


public class Food extends Item {
    private static final String assetPath = "assets/seed.png";
    private boolean isFresh;

    Food(Vec2d position) {
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

    public boolean isFresh() {
        return isFresh;
    }



}
