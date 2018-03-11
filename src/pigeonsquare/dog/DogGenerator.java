package pigeonsquare.dog;

import javafx.application.Platform;
import pigeonsquare.Environment;
import pigeonsquare.Item;
import pigeonsquare.Main;

import java.util.Random;

/**
 * Dog generator class.
 */
public class DogGenerator implements Runnable {
    private final boolean running;

    /**
     * Constructor
     */
    public DogGenerator() {
        this.running = true;
    }

    /**
     * Generate a dog randomly between 10 ms and 10 sec.
     */
    @Override
    public void run() {
        while (this.running) {
            Random r = new Random();
            int min = 10;
            int max = 10000;
            int sleepCreateDog = r.nextInt(max - min) + min;
            try {
                Thread.sleep(sleepCreateDog);
            } catch (InterruptedException e) { break; }

            Item newDog = Environment.getInstance().addDog();
            Thread threadDog = new Thread(newDog);
            threadDog.start();
            Platform.runLater(() -> Main.addGraphicItem((newDog.getImageView())));
        }
    }
}