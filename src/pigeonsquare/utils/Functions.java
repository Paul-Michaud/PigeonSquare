package pigeonsquare.utils;

import java.util.Random;

public class Functions {
    public static Position randomCoordsInWindow() {
        Random random = new Random();
        int randomX = random.nextInt(Constants.SCREEN_WIDTH);
        int randomY = random.nextInt(Constants.SCREEN_HEIGHT);
        return new Position(randomX,randomY);
    }
}
