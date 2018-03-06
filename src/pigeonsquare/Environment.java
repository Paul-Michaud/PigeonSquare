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

public class Environment {
    private static final Environment environment = new Environment();
    private final List<Pigeon> pigeons;
    private final List<Food> foodList;

    private Environment() {
        this.pigeons = new ArrayList<>();
        this.foodList = new ArrayList<>();
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

    public void removeFood(Food food) {
        // TODO : Check if pigeon on food ? -> ok with the lock ?
        food.lock();
        foodList.remove(food);
        food.unlock();
        Platform.runLater(() -> Main.removeGraphicItem(food.getImageView()));
    }

    public void reset() {
        List<Item> items = new ArrayList<>();
        items.addAll(this.pigeons);
        items.addAll(this.foodList);

        for(Item item : items){
            item.lock();
            Main.removeGraphicItem(item.getImageView());
            item.stop();
            item.unlock();

        }

        this.pigeons.clear();
        this.foodList.clear();
    }



    /**
     Get the nearest food from a specified position
     @param position The position we're searching from
     @return The position of the nearest food
     */
    public Vec2d getNearestFood(Vec2d position) {
        double minDist = Double.POSITIVE_INFINITY;
        Vec2d nearestFood = null;
        for (Food food : foodList) {
            food.lock();
            double dist = food.position.distance(position);
            if (dist < minDist && food.isFresh()){
                minDist = dist;
                nearestFood = food.getPosition();
            }
            food.unlock();
        }


        return nearestFood;
    }

}
