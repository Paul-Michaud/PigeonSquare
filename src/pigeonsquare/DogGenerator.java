package pigeonsquare;

import javafx.application.Platform;

import java.util.Random;

class DogGenerator implements Runnable {

    private final boolean running;

    DogGenerator() {
        this.running = true;
    }

    /**
     * This method will create a dog randomly between 10 ms and 10 sec
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
            } catch (InterruptedException e) {
                System.out.println("Thread stopped");
                break;
            }
            Item newDog = Environment.getInstance().addDog();
            Thread threadDog = new Thread(newDog);
            threadDog.start();

            Platform.runLater(() -> Main.addGraphicItem((newDog.getImageView())));




        }
    }
}