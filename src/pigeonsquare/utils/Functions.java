package pigeonsquare.utils;

import com.sun.javafx.geom.Vec2d;

import java.util.Random;

public class Functions {
    public static Vec2d randomCoordsInWindow() {
        Random random = new Random();
        int randomX = random.nextInt(WindowsProperties.getWindowsWidth());
        int randomY = random.nextInt(WindowsProperties.getWindowsHeight());
        return new Vec2d(randomX,randomY);
    }


}
