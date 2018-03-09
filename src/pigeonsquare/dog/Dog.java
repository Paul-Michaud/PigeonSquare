package pigeonsquare.dog;

import pigeonsquare.Environment;
import pigeonsquare.Item;
import pigeonsquare.MobileItem;
import pigeonsquare.utils.Position;

public class Dog extends MobileItem {

    private static final String assetPath = "assets/dog.png";

    public Dog(Position position) {
        this.position = position;
        this.loadImage(assetPath);
        this.speed = 0;
    }
    public void move(Item goal) {

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
