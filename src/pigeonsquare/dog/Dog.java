package pigeonsquare.dog;

import com.sun.javafx.geom.Vec2d;
import pigeonsquare.Environment;
import pigeonsquare.Item;

public class Dog extends Item {

    private static final String assetPath = "assets/dog.png";

    public Dog(Vec2d position) {
        this.position = position;
        this.loadImage(assetPath);
    }
    @Override
    public void run() {
        while (this.running) {
            try {
                Thread.sleep(3000);
                Environment.getInstance().removeItem(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
