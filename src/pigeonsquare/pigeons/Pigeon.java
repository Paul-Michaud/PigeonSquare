package pigeonsquare.pigeons;

import com.sun.javafx.geom.Vec2d;
import pigeonsquare.*;

import java.util.Random;

abstract public class Pigeon extends MobileItem {

    Pigeon() {
        Random random = new Random();
        this.speed = random.nextInt(201);
    }

    @Override
    public void run() {
        while (this.running) {

            Item goal = Environment.getInstance().getGoal(this.position);

            if(goal != null) {
                Vec2d goalPosition = goal.getPosition();
                if(goal instanceof Dog) {
                    System.out.println("Go away from dog at pos : X("+goalPosition.x+") Y("+goalPosition.y+")");
                }
                if(goal instanceof Food) {
                    System.out.println("Go toward food at pos : X("+goalPosition.x+") Y("+goalPosition.y+")");
                }
            } else {
                //Si pas de nourriture on fait quoi ? On va qqe part au hasard ?
            }


            try {
                Thread.sleep(this.thirtyFPS);
            } catch (InterruptedException e) {
                System.out.println("Thread stopped");
                break;
            }
        }
    }
}
