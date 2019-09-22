import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    private double FIELD_WIDTH = 400;
    private double FIELD_HEIGHT = 400;

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
        CheckersDrawer.init(stage);
    }
}
