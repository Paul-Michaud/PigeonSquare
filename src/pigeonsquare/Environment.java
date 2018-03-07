package pigeonsquare;

import com.sun.javafx.geom.Vec2d;
import javafx.application.Platform;
import pigeonsquare.pigeons.Biset;
import pigeonsquare.pigeons.Colombin;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.pigeons.Ramier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Environment {
    private static final Environment environment = new Environment();
    private final List<Pigeon> pigeons;
    private final List<Food> foodList;
    private final List<Dog> dogList;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private Environment() {
        this.pigeons = new ArrayList<>();
        this.foodList = new ArrayList<>();
        this.dogList = new ArrayList<>();
    }

    public static Environment getInstance() {
        return environment;
    }

    public Item addPigeon() {
        Item item;
        Random random = new Random();

        int randomX = random.nextInt(800);
        int randomY = random.nextInt(800);
        Vec2d position = new Vec2d(randomX,randomY);

        switch (random.nextInt(3) + 1) {
            case 1:
                item = new Biset(position);
                pigeons.add((Pigeon)item);
                return item;
            case 2:
                item = new Colombin(position);
                pigeons.add((Pigeon)item);
                return item;
            case 3:
                item = new Ramier(position);
                pigeons.add((Pigeon)item);
                return item;
            default:
                return null;
        }
    }

    public Item addFood(Vec2d position) {
        Item item;
        item = new Food(position);
        foodList.add((Food) item);
        return item;
    }

    public void removeItem(Item i) {
        lock.writeLock().lock();
        try {
            foodList.remove(i);
            i.stop();
            Platform.runLater(() -> Main.removeGraphicItem(i.getImageView()));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Item addDog() {
        Item item;
        Random random = new Random();

        int randomX = random.nextInt(800);
        int randomY = random.nextInt(800);
        Vec2d position = new Vec2d(randomX,randomY);

        item = new Dog(position);
        dogList.add((Dog) item);

        return item;
    }

    public void reset() {
        List<Item> items = new ArrayList<>();
        items.addAll(this.pigeons);
        items.addAll(this.foodList);
        items.addAll(this.dogList);
        lock.writeLock().lock();
        try {
            for (Item item : items) {
                Main.removeGraphicItem(item.getImageView());
                item.stop();
            }
            this.pigeons.clear();
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

    public Item getGoal(Vec2d position) {
        double minDist = Double.POSITIVE_INFINITY;
        Item goal = null;

        List<Item> items = new ArrayList<>();
        items.addAll(this.dogList);
        items.addAll(this.foodList);

        lock.writeLock().lock();
        try {
            for (Item i : items) {
                double dist = i.position.distance(position);
                if (dist < minDist) {
                    if(i instanceof Food && ((Food) i).isFresh()) {
                        minDist = dist;
                        goal = i;
                    }
                    if(i instanceof Dog) {
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

}
