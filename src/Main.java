import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

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
            }
        });
        root.setStyle("-fx-background-color: pink");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }
}


