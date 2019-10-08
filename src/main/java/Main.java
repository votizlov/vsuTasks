import interfaceControllers.CheckersDrawer;
import javafx.application.Application;
import javafx.stage.Stage;
import mainLogic.GameSession;
import mainLogic.SessionType;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {

    private double FIELD_WIDTH = 400;
    private double FIELD_HEIGHT = 400;

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        GameSession currentSession = new GameSession(SessionType.PVE);

        System.out.print("BBB");
        System.out.print("\r f");
        //launch(args);
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
