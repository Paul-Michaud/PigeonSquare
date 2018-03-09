package pigeonsquare;

import javafx.application.Platform;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.utils.Constants;

import java.util.Random;

public abstract class MobileItem extends Item {

    protected int speed;
    private final int sixtyFPS = 16;
    private final int thirtyFPS = 32;
    private final int oneTwentyFPS = 8;

    protected MobileItem() {

    }

    protected abstract void move(Item goal);

    @Override
    public void run() {
        while (this.running) {
            if(this instanceof Pigeon) {
                Item goal = Environment.getInstance().getPigeonGoal(this.position);

                if (goal != null) {
                    move(goal);
                }
                //We check if the position is not out of bound
                this.position.x = Math.max(Math.min(this.position.x, Constants.SCREEN_WIDTH - this.imageView.getFitWidth()), 0);
                this.position.y = Math.max(Math.min(this.position.y, Constants.SCREEN_HEIGHT - this.imageView.getFitHeight()), 25);

                Platform.runLater(() -> {
                    this.imageView.setX(this.position.x);
                    this.imageView.setY(this.position.y);
                    ((Pigeon) this).text.relocate(this.position.x+10, this.position.y+this.getImageView().getFitHeight());
                });

                //if close enough to a food a pigeon will eat it
                if (goal instanceof Food && this.isClose(goal) && ((Food) goal).isFresh()) {
                    Environment.getInstance().removeItem(goal);
                    ((Pigeon) this).incrementFoodEaten();

                }
            }
            try {
                Thread.sleep(this.sixtyFPS);
            } catch (InterruptedException e) {
                System.out.println("Thread stopped");
                break;
            }
        }
    }


    }
