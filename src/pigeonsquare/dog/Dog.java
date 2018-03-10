package pigeonsquare.dog;

import pigeonsquare.Environment;
import pigeonsquare.Item;
import pigeonsquare.MobileItem;
import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

public class Dog extends MobileItem {

    public Dog(Position position) {
        this.position = position;
        this.loadImage(Constants.PATH_DOG);
        this.speed = 0;
    }

    public void move(Item goal) {}

    @Override
    public void run() {
        while (this.running) {
            try {
                Thread.sleep(Constants.DOG_LIFE_TIME);
                Environment.getInstance().removeItem(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}