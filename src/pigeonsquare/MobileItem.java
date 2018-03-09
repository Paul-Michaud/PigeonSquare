package pigeonsquare;

import javafx.application.Platform;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.utils.WindowsProperties;

public abstract class MobileItem extends Item {

    protected int speed;
    protected final int sixtyFPS = 16;
    protected final int thirtyFPS = 32;
    protected final int oneTwentyFPS = 8;

    protected MobileItem() {

    }

    public abstract void move(Item goal);

    @Override
    public void run() {
        while (this.running) {
            Item goal = Environment.getInstance().getGoal(this.position);

            if(goal != null) {
                move(goal);
            }
            //We check if the position is not out of bound
            this.position.x = Math.max(Math.min(this.position.x, WindowsProperties.getWindowsWidth() - this.imageView.getFitWidth()), 0);
            this.position.y = Math.max(Math.min(this.position.y, WindowsProperties.getWindowsHeight() - this.imageView.getFitHeight()), 25);

            Platform.runLater(() -> {
                this.imageView.setX(this.position.x);
                this.imageView.setY(this.position.y);
            });

            //if close enought to a food a pigeon will eat it
            if(this instanceof Pigeon && goal instanceof Food && this.isClose(goal)) {
                Environment.getInstance().removeItem(goal);
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
