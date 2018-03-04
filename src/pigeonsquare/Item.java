package pigeonsquare;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.sun.javafx.geom.Vec2d;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Item implements Runnable {

    private ImageView imageView;
    protected Vec2d position;
    private double paddingX;
    private double paddingY;
    protected boolean running;

    Item(){
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

            this.paddingX = image.getWidth()/2.0;
            this.paddingY = image.getHeight()/2.0;

            imageView.setX(this.position.x-paddingX);
            imageView.setY(this.position.y-paddingY);
            imageView.setFitHeight(image.getHeight());
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {

    }

    }
