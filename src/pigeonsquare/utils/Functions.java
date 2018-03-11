package pigeonsquare.utils;

import java.util.Random;

/**
 * Useful functions
 */
public class Functions {
    /**
     * Return a random position in the window
     * @return A new random position
     */
    public static Position randomCoordsInWindow() {
        Random random = new Random();
        int randomX = random.nextInt(Constants.SCREEN_WIDTH);
        int randomY = random.nextInt(Constants.SCREEN_HEIGHT);
        return new Position(randomX,randomY);
    }
}
