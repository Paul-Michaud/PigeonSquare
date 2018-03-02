package pigeonsquare.pigeons;

import pigeonsquare.MobileItem;
import java.util.Random;

abstract public class Pigeon extends MobileItem {

    public Pigeon() {
        Random random = new Random();
        this.speed = random.nextInt(201);
    }
}
