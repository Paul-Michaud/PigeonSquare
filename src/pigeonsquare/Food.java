package pigeonsquare;

import pigeonsquare.utils.Position;

public class Food extends Item {
    private static final String assetPath = "assets/seed.png";

    public Food(Position position) {
        this.position = position;
        this.loadImage(assetPath);
    }
}
