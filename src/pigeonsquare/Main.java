package pigeonsquare;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pigeonsquare.utils.Position;

public class Main extends Application {
    Environment env;
    private static Pane root = new Pane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.env = new Environment();
        primaryStage.setTitle("Pigeon Square");

        Button btnReset = new Button();
        btnReset.setText("Reset");
        btnReset.setOnAction(event -> Square.getInstance().reset());

        btnReset.setLayoutX(0);
        btnReset.setLayoutY(0);
        root.getChildren().add(btnReset);

        // ADD RANDOM PIGEON BUTTON
        Button btnAddPigeon = new Button();
        btnAddPigeon.setText("Add random pigeon");
        btnAddPigeon.setLayoutX(60);
        btnAddPigeon.setLayoutY(0);
        btnAddPigeon.setOnAction(event -> {
            System.out.println("Add Pigeon");
            Item item = Square.getInstance().addPigeon();
            if(item != null){
                root.getChildren().add(item.getImageView());
                Thread thread = new Thread(item);
                thread.start();
            }
        });
        root.getChildren().add(btnAddPigeon);

        // ADD FOOD ACTION
        root.setOnMouseClicked(me -> {
            Position position = new Position(me.getX(),me.getY());
            Item item = null;

            // LEFT CLICK : ADD FOOD
            if(me.getButton() == MouseButton.PRIMARY) item = Square.getInstance().addFood(position);
            if (item != null) root.getChildren().add(item.getImageView());
        });

        root.setStyle("-fx-background-color: white");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

    public static void removeGraphicItem(Node node){
        root.getChildren().remove(node);
    }
}


