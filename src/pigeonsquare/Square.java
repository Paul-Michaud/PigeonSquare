package pigeonsquare;

import javafx.application.Platform;
import pigeonsquare.pigeons.Biset;
import pigeonsquare.pigeons.Colombin;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.pigeons.Ramier;
import pigeonsquare.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Square {
    private static Square square = new Square();
    private List<Pigeon> pigeons;
    private List<Food> foodList;


    public Square() {
        this.pigeons = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public static Square getInstance() {
        return square;
    }

    public Item addPigeon() {
        Item item;
        Random random = new Random();

        int randomX = random.nextInt(800);
        int randomY = random.nextInt(800);
        Position position = new Position(randomX,randomY);

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

    public Item addFood(Position position) {
        Item item;
        item = new Food(position);
        foodList.add((Food) item);
        return item;
    }

    public void removeFood(Food food) {
        // TODO : Check if piheon on food ?
        foodList.remove(food);
        Platform.runLater(() -> Main.removeGraphicItem(food.getImageView()));
    }

    public void reset() {
        List<Item> items = new ArrayList<>();
        items.addAll(this.pigeons);
        items.addAll(this.foodList);

        for(Item item : items){
            Main.removeGraphicItem(item.getImageView());
            item.stop();
        }

        this.pigeons.clear();
        this.foodList.clear();
    }
}
