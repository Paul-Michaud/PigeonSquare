package pigeonsquare.dog;

import pigeonsquare.Environment;
import pigeonsquare.Item;
import pigeonsquare.MobileItem;
import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

/**
 * Dog class.
 */
public class Dog extends MobileItem {

    /**
     * Constructor
     * @param position The initial position
     */
    public Dog(Position position) {
        this.position = position;
        this.loadImage(Constants.PATH_DOG);
        this.speed = 0;
    }

    public void move(Item goal) {}

    /**
     * Life cycle of the dog (he disappears after a few seconds)
     */
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