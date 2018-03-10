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
                this.imageView.setFitHeight(32);
                this.imageView.setFitWidth(32);
            }

            if(this instanceof Dog) {
                this.imageView.setFitHeight(64);
                this.imageView.setFitWidth(64);
            }

            if(this instanceof Pigeon && this instanceof Ramier) {
                this.imageView.setFitHeight(80);
                this.imageView.setFitWidth(80);
            }

            if(this instanceof Pigeon && this instanceof Biset) {
                this.imageView.setFitHeight(64);
                this.imageView.setFitWidth(64);
            }

            if(this instanceof Pigeon && this instanceof Colombin) {
                this.imageView.setFitHeight(48);
                this.imageView.setFitWidth(48);
            }

            //Without padding to food wouldn't appear
            //at the center of our mouse click
            double paddingX = imageView.getFitWidth() / 2.0;
            double paddingY = imageView.getFitHeight() / 2.0;
            this.position.x -= paddingX;
            this.position.y -= paddingY;

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
    public void run() {

    }

}
