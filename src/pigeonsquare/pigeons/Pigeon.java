package pigeonsquare.pigeons;

import pigeonsquare.*;
import pigeonsquare.dog.Dog;
import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

import java.util.Random;

/**
 * Pigeon class. Contains the functions which are common to all sorts of pigeons.
 */
abstract public class Pigeon extends MobileItem {
    private int foodEaten;

    /**
     * Constructor
     */
    Pigeon() {
        Random random = new Random();
        this.speed = random.nextInt(Constants.MAX_SPEED-Constants.MIN_SPEED) + Constants.MIN_SPEED;
        this.foodEaten = 0;
    }

    /**
     * Make the pigeon move to his target item.
     * @param goal The food to reach
     */
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

    /**
     * Male the pigeon eat the food
     * @param goal The food to eat
     */
    public void eatFood(Item goal) {
        if(Environment.getInstance().removeItem(goal)) {
            this.foodEaten++;
            this.text.setText(foodEaten+" food");
        }
    }
}
