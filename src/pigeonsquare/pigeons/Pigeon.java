package pigeonsquare.pigeons;

import com.sun.javafx.geom.Vec2d;
import pigeonsquare.Environment;
import pigeonsquare.MobileItem;

import java.util.Random;

abstract public class Pigeon extends MobileItem {

    Pigeon() {
        Random random = new Random();
        this.speed = random.nextInt(201);
    }

    @Override
    public void run() {
        while (this.running) {
            try {
                Thread.sleep(this.thirtyFPS);

                Vec2d nearestFood = Environment.getInstance().getNearestFood(this.position);
                if(nearestFood != null) {
                    System.out.println("X : " + nearestFood.x + ", Y : " + nearestFood.y);
                }

            } catch (InterruptedException e) {
                System.out.println("Thread stopped");
                break;
            }




        }
    }
}
