import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckersDrawer {
    private GameSession currentSession;
    private static CheckersDrawer instance;
    private GraphicsContext gc;
    private Stage stage;

    private CheckersDrawer(Stage stage) {
        this.stage = stage;
    }

    public static CheckersDrawer getInstance(GameSession currentSession) {
        instance.currentSession = currentSession;
        return instance;
    }

    public static CheckersDrawer init(Stage stage) {
        if (instance == null) {
            instance = new CheckersDrawer(stage);
        }

        return instance;
    }

    public void drawBoard() {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    public void updateBoard() {

    }
}
