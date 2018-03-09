package pigeonsquare;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pigeonsquare.utils.Position;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Item implements Runnable {

    protected ImageView imageView;
    protected Position position;
    protected boolean running;

    protected Item(){
        this.running = true;
    }

    public ImageView getImageView() {
        return imageView;
    }

    protected void loadImage(String path) {
        try {
            Image image = new Image(new FileInputStream(path));
            imageView = new ImageView();
            imageView.setImage(image);

            double paddingX = image.getWidth() / 2.0;
            double paddingY = image.getHeight() / 2.0;

            imageView.setX(this.position.x - paddingX);
            imageView.setY(this.position.y - paddingY);
            //Then we can center the position to the center of the image (not top left corner) if it's a food
            //because it is created with a mouse click
            //This condition is a bit ugly but since we only create the food with the mouse it's fine
            if(this instanceof Food) {
                this.position.y = this.position.y - paddingY;
                this.position.x = this.position.x - paddingX;
            }

            imageView.setFitHeight(image.getHeight());
            imageView.setFitWidth(image.getWidth());
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.running = false;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isClose(Item goal) {
        //Define the threshold
        return (this.position.distance(goal.getPosition()) < 15) ? true : false;
    }
    @Override
    public void run() {

    }

}
