package pigeonsquare.utils;

import java.util.Random;

public class Functions {
    public static Position randomCoordsInWindow() {
        Random random = new Random();
        int randomX = random.nextInt(WindowsProperties.getWindowsWidth());
        int randomY = random.nextInt(WindowsProperties.getWindowsHeight());
        return new Position(randomX,randomY);
    }


}
