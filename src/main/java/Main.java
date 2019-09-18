import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    private double FIELD_WIDTH = 800;
    private double FIELD_HEIGHT = 800;

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        //GameSession currentSession = new GameSession(SessionType.PVE);
        launch(args);
    }

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Checkers");
        Group root = new Group();
        Canvas canvas = new Canvas(FIELD_WIDTH, FIELD_HEIGHT);
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseEvent.getX();
            }
        });
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Rectangle r = new Rectangle();
        r.setHeight(FIELD_HEIGHT / 8);
        r.setWidth(FIELD_WIDTH / 8);
        r.setX(0);
        r.setY(0);
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
    }
}
