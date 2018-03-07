package pigeonsquare;

import com.sun.javafx.geom.Vec2d;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pigeonsquare.dog.*;
import pigeonsquare.utils.*;

public class Main extends Application {
    private static final Pane root = new Pane();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pigeon Square");
        Button btnReset = new Button();
        btnReset.setText("Reset");
        btnReset.setOnAction(event -> Environment.getInstance().reset());

        btnReset.setLayoutX(0);
        btnReset.setLayoutY(0);
        root.getChildren().add(btnReset);

        // DOG GENERATOR
        Thread threadDogGenerator = new Thread(new DogGenerator());
        threadDogGenerator.start();

        // ADD RANDOM PIGEON BUTTON
        Button btnAddPigeon = new Button();
        btnAddPigeon.setText("Add random pigeon");
        btnAddPigeon.setLayoutX(60);
        btnAddPigeon.setLayoutY(0);
        btnAddPigeon.setOnAction(event -> {
            System.out.println("Add Pigeon");
            Item item = Environment.getInstance().addPigeon();
            if(item != null){
                root.getChildren().add(item.getImageView());
                Thread thread = new Thread(item);
                thread.start();
            }
        });
        root.getChildren().add(btnAddPigeon);

        // ADD FOOD ACTION
        root.setOnMouseClicked(me -> {
            Vec2d position = new Vec2d(me.getX(),me.getY());
            Item item = null;
            if(me.getButton() == MouseButton.PRIMARY) item = Environment.getInstance().addFood(position);
            if (item != null) {
                root.getChildren().add(item.getImageView());
                Thread thread = new Thread(item);
                thread.start();
            }
        });

        root.setStyle("-fx-background-color: white");
        primaryStage.setScene(new Scene(root, WindowsProperties.getWindowsWidth(), WindowsProperties.getWindowsHeight()));
        primaryStage.show();
    }

    public static void removeGraphicItem(Node node){
        root.getChildren().remove(node);
    }

    public static void addGraphicItem(Node node){
        root.getChildren().add(node);
    }

}


