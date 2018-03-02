package pigeonsquare;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pigeonsquare.utils.Position;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Item {
    protected ImageView imageView;
    protected Position position;
    protected double paddingX,paddingY;

    public ImageView getImageView() {
        return imageView;
    }

    public Position getPosition() {
        return position;
    }

    public void loadImage(String path) {
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
}
