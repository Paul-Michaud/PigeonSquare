package pigeonsquare.pigeons;

import pigeonsquare.Mobile;

import java.util.Random;



abstract public class Pigeon extends Mobile {

    public Pigeon(double posX, double posY) {
        super(posX, posY);
        Random random = new Random();
        this.speed = random.nextInt(201);
    }
}
