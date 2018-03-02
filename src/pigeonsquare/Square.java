package pigeonsquare;

import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.utils.Position;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private static Square square = new Square();
    private List<Pigeon> pigeons;
    private List<Food> foodList;


    public Square() {
        this.foodList = new ArrayList<>();
    }

    public static Square getInstance() {
        return square;
    }

    public Item addFood(Position position) {
        Item item;
        item = new Food(position);
        foodList.add((Food) item);
        System.out.println("Food added");
        return item;
    }
}
