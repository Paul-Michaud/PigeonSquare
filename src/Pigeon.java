import java.util.Random;

public class Pigeon extends Mobile {

    public Pigeon(double posX, double posY) {
        super(posX, posY);
        Random random = new Random();
        this.speed = random.nextInt(201);
    }
}
