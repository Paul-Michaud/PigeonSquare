package pigeonsquare;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pigeonsquare.dog.Dog;
import pigeonsquare.pigeons.Biset;
import pigeonsquare.pigeons.Colombin;
import pigeonsquare.pigeons.Pigeon;
import pigeonsquare.pigeons.Ramier;
import pigeonsquare.utils.Constants;
import pigeonsquare.utils.Position;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Item implements Runnable {
    ImageView imageView;
    protected final Text text;
    protected Position position;
    protected boolean running;

    Item(){
        this.running = true;
        this.text = new Text();
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    protected void loadImage(String path) {
        try {
            Image image = new Image(new FileInputStream(path));
            this.imageView = new ImageView();
            this.imageView.setImage(image);

            if(this instanceof Food) {
                this.imageView.setFitHeight(Constants.FOOD_SIZE);
                this.imageView.setFitWidth(Constants.FOOD_SIZE);
            }

            if(this instanceof Dog) {
                this.imageView.setFitHeight(Constants.DOG_SIZE);
                this.imageView.setFitWidth(Constants.DOG_SIZE);
            }

            if(this instanceof Pigeon && this instanceof Ramier) {
                this.imageView.setFitHeight(Constants.RAMIER_SIZE);
                this.imageView.setFitWidth(Constants.RAMIER_SIZE);
            }

            if(this instanceof Pigeon && this instanceof Biset) {
                this.imageView.setFitHeight(Constants.BISET_SIZE);
                this.imageView.setFitWidth(Constants.BISET_SIZE);
            }

            if(this instanceof Pigeon && this instanceof Colombin) {
                this.imageView.setFitHeight(Constants.COLOMBIN_SIZE);
                this.imageView.setFitWidth(Constants.COLOMBIN_SIZE);
            }

            //Without padding to food wouldn't appear
            //at the center of our mouse click

            double paddingX = imageView.getFitWidth() / 2.0;
            double paddingY = imageView.getFitHeight() / 2.0;
            this.position.x -= paddingX;
            this.position.y -= paddingY;

            this.position.x = Math.max(Math.min(this.position.x, Constants.SCREEN_WIDTH - this.imageView.getFitWidth()), 0);
            this.position.y = Math.max(Math.min(this.position.y, Constants.SCREEN_HEIGHT - this.imageView.getFitHeight()), 25);

            this.imageView.setX(this.position.x);
            this.imageView.setY(this.position.y);

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

    public Text getText() {
        return text;
    }

    @Override
    public void run() { }

}
