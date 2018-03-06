package pigeonsquare;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.sun.javafx.geom.Vec2d;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Item implements Runnable {

    private ImageView imageView;
    protected Vec2d position;
    protected boolean running;
    private final ReentrantLock lock = new ReentrantLock();


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

            double paddingX = image.getWidth() / 2.0;
            double paddingY = image.getHeight() / 2.0;

            imageView.setX(this.position.x- paddingX);
            imageView.setY(this.position.y- paddingY);
            imageView.setFitHeight(image.getHeight());
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.running = false;
    }

    public Vec2d getPosition() {
        return position;
    }

    @Override
    public void run() {

    }

    public void lock() {
        this.lock.lock();
    }

    public void unlock() {
        this.lock.unlock();
    }

}
