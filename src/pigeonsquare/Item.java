package pigeonsquare;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pigeonsquare.dog.Dog;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Item implements Runnable {

    ImageView imageView;
    protected Position position;
    protected boolean running;

    Item(){
        this.running = true;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    protected void loadImage(String path) {
        try {
            Image image = new Image(new FileInputStream(path));
            this.imageView = new ImageView();
            this.imageView.setImage(image);

            double paddingX = image.getWidth() / 2.0;
            double paddingY = image.getHeight() / 2.0;

            this.imageView.setX(this.position.x - paddingX);
            this.imageView.setY(this.position.y - paddingY);
            //Then we can center the position to the center of the image (not top left corner) if it's a food
            //because it is created with a mouse click
            //This condition is a bit ugly but since we only create the food with the mouse it's fine
            if(this instanceof Food) {
                this.position.y = this.position.y - paddingY;
                this.position.x = this.position.x - paddingX;
                this.imageView.setFitHeight(32);
                this.imageView.setFitWidth(32);
            }
            if(this instanceof Pigeon || this instanceof Dog) {
                this.imageView.setFitHeight(64);
                this.imageView.setFitWidth(64);
            }

            this.imageView.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void changeImage(String newPath) {
        try {
            Image image = new Image(new FileInputStream(newPath));
            this.imageView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.running = false;
    }

    public Position getPosition() {
        return this.position;
    }

    boolean isClose(Item goal) {
        //Define the threshold
        return this.position.distance(goal.getPosition()) < Constants.IS_CLOSE;
    }
    @Override
    public void run() {

    }

}
