import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CheckersDrawer {
    private GameSession currentSession;
    private GraphicsContext gc;

    CheckersDrawer(GameSession currentSession) {
        this.currentSession = currentSession;
    }

    public void drawBoard() {
        Stage stage = new Stage();
        stage.setTitle("Checkers");
        Group root = new Group();
        Canvas canvas = new Canvas(300,300);
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseEvent.getX();
            }
        });
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
    }

    public void updateBoard(){

    }

}
