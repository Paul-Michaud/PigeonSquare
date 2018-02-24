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

        Button btn = new Button();
        btn.setText("Reset");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        Pane root = new Pane();
        btn.setLayoutX(0);
        btn.setLayoutY(0);
        root.getChildren().add(btn);

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

                    Random random = new Random();
                    int randomNumber = random.nextInt(3) + 1;
                    switch (randomNumber) {
                        case 1:
                            allMobile.add(new Ramier(me.getX(), me.getY()));
                            break;
                        case 2:
                            allMobile.add(new Colombin(me.getX(), me.getY()));
                            break;
                        case 3:
                            allMobile.add(new Biset(me.getX(), me.getY()));
                            break;
                    }

                    for (Mobile m : allMobile) {
                        System.out.println(m.getSpeed());
                    }
                }
                if(me.getButton() == MouseButton.SECONDARY) {
                    System.out.println("Right click");
                }
                if(me.getButton() == MouseButton.MIDDLE) {
                    System.out.println("Middle click");
                }
            }
        });



        root.setStyle("-fx-background-color: pink");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }
}


