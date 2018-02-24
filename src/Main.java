import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    Environment env;
    ArrayList<Mobile> allMobile = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.env = new Environment();
        primaryStage.setTitle("Pigeon Square !");

        Button btnReset = new Button();
        btnReset.setText("Reset");
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Reset");
            }
        });

        Pane root = new Pane();
        btnReset.setLayoutX(0);
        btnReset.setLayoutY(0);
        root.getChildren().add(btnReset);

        Button btnAddPigeon = new Button();
        btnAddPigeon.setText("Add Pigeon");
        btnAddPigeon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Pigeon");

                Random random = new Random();
                int randomNumber = random.nextInt(3) + 1;
                int randomX = random.nextInt(800);
                int randomY = random.nextInt(800);
                switch (randomNumber) {
                    case 1:
                        allMobile.add(new Ramier(randomX, randomY));
                        break;
                    case 2:
                        allMobile.add(new Colombin(randomX, randomY));
                        break;
                    case 3:
                        allMobile.add(new Biset(randomX, randomY));
                        break;
                }
            }
        });

        btnAddPigeon.setLayoutX(60);
        btnAddPigeon.setLayoutY(0);
        root.getChildren().add(btnAddPigeon);


        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("X:" + me.getX() + " Y:" + me.getY());
                if(me.getButton() == MouseButton.PRIMARY) {
                    System.out.println("Left click");
                    
                    final ImageView imv = new ImageView();
                    final Image image2 = new Image(Main.class.getResourceAsStream("flip.jpg"));
                    imv.setImage(image2);
                    imv.setLayoutX(me.getX());
                    imv.setLayoutY(me.getY());
                    root.getChildren().add(imv);

                }
            }
        });



        root.setStyle("-fx-background-color: pink");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }
}


