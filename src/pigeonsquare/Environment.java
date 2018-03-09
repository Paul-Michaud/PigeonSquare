package pigeonsquare;

import javafx.application.Platform;
import pigeonsquare.dog.Dog;
import pigeonsquare.pigeons.Biset;
import pigeonsquare.pigeons.Colombin;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.pigeons.Ramier;
import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static pigeonsquare.utils.Functions.*;

public class Environment {
    private static final Environment environment = new Environment();
    private final List<Pigeon> pigeonsList;
    private final List<Food> foodList;
    private final List<Dog> dogList;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Environment() {
        this.pigeonsList = new ArrayList<>();
        this.foodList = new ArrayList<>();
        this.dogList = new ArrayList<>();
    }

    public static Environment getInstance() {
        return environment;
    }

    /**
     Add a new pigeon to the environment at a random position
     The type of the pigeon is randomly chosen between Biset/Colombin/Ramier
     @return The pigeon created
     */

    public Item addPigeon() {
        Item item;
        Random random = new Random();

        Position position = randomCoordsInWindow();

        switch (random.nextInt(3) + 1) {
            case 1:
                item = new Biset(position);
                pigeonsList.add((Pigeon)item);
                return item;
            case 2:
                item = new Colombin(position);
                pigeonsList.add((Pigeon)item);
                return item;
            case 3:
                item = new Ramier(position);
                pigeonsList.add((Pigeon)item);
                return item;
            default:
                return null;
        }
    }

    /**
     Add a new food to the environment at a specified position
     @return The food created
     */

    public Item addFood(Position position) {
        Item item;
        lock.writeLock().lock();
        item = new Food(position);
        foodList.add((Food) item);
        lock.writeLock().unlock();

        return item;
    }

    /**
     Remove an item from the environment and from the graphic interface
     @param i  The item to be removed
     */

    public void removeItem(Item i) {
        lock.writeLock().lock();
        try {
            if(i instanceof Food) removeFood((Food)i);
            if(i instanceof Dog) removeDog((Dog)i);
            if(i instanceof Pigeon) removePigeon((Pigeon)i);
            i.stop();
            Platform.runLater(() -> Main.removeGraphicItem(i));
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     Add a new dog to the environment at a random position
     @return The dog created
     */

    public Item addDog() {
        Item item;
        Position position = randomCoordsInWindow();
        lock.writeLock().lock();
        item = new Dog(position);
        dogList.add((Dog) item);
        lock.writeLock().unlock();
        return item;
    }

    /**
     Reinitialize the game
     */

    public void reset() {
        List<Item> items = new ArrayList<>();
        items.addAll(this.pigeonsList);
        items.addAll(this.foodList);
        items.addAll(this.dogList);
        lock.writeLock().lock();
        try {
            for (Item item : items) {
                Main.removeGraphicItem(item);
                item.stop();
            }
            this.pigeonsList.clear();
            this.foodList.clear();
            this.dogList.clear();
        } finally {
            lock.writeLock().unlock();
        }

    }



    /**
     Get the best goal from a specified position
     Goal is an item, can be something to go to or to go away from
     @param position The position we're searching from
     @return The goal (item)
     */

    public Item getPigeonGoal(Position position) {
        double minDist = Double.POSITIVE_INFINITY;
        Item goal = null;
        lock.writeLock().lock();
        List<Item> items = new ArrayList<>();
        items.addAll(this.dogList);
        items.addAll(this.foodList);

        try {
            for (Item i : items) {
                double dist = i.position.distance(position);
                if (dist < minDist) {
                    if(i instanceof Food && ((Food) i).isFresh()) {
                        minDist = dist;
                        goal = i;
                    }
                    if(i instanceof Dog && dist < Constants.IS_SCARED) {
                        minDist = dist;
                        goal = i;
                    }
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
        return goal;
    }

    /**
     Remove a food from the food list if it exists
     @param food The food to be removed
     */

    private void removeFood(Food food) {
        if(foodList.contains(food)) {
            foodList.remove(food);
        }
    }

    /**
     Remove a dog from the dog list if it exists
     @param dog The dog to be removed
     */

    private void removeDog(Dog dog) {
        if(dogList.contains(dog)) dogList.remove(dog);

    }

    /**
     Remove a pigeon from the pigeon list if it exists
     @param pigeon The pigeon to be removed
     */

    private void removePigeon(Pigeon pigeon) {
        if(pigeonsList.contains(pigeon)) pigeonsList.remove(pigeon);

    }
}
