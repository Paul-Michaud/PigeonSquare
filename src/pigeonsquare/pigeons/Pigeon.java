package pigeonsquare.pigeons;

import pigeonsquare.*;
import pigeonsquare.dog.Dog;
import pigeonsquare.utils.Position;

import java.util.Random;

abstract public class Pigeon extends MobileItem {
    protected int foodEaten;
    Pigeon() {
        Random random = new Random();
        int minSpeed = 100;
        int maxSpeed = 600;
        this.speed = random.nextInt(maxSpeed-minSpeed) + minSpeed;
        this.foodEaten = 0;
    }

    public void move(Item goal) {
        //Init to old position in case we are not in any of the following if
        Position newPosition =  new Position(this.position.x, this.position.y);
        if(goal instanceof Food) {
            newPosition = new Position(goal.getPosition().x - this.position.x,goal.getPosition().y - this.position.y);
        }
        if(goal instanceof Dog) {
            newPosition = new Position((goal.getPosition().x - this.position.x) * -1,(goal.getPosition().y - this.position.y) *-1);
        }
        newPosition.normalize();
        this.position.x += newPosition.x * (this.speed/100.0);
        this.position.y += newPosition.y * (this.speed/100.0);
    }

    public void incrementFoodEaten() {
        this.foodEaten++;
        this.text.setText("Food "+foodEaten);
    }

    public int getFoodEaten() {
        return foodEaten;
    }
}
