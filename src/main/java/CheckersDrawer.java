import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckersDrawer  {
    private GameSession currentSession;
    private GraphicsContext gc;

    CheckersDrawer(GameSession currentSession) {
        this.currentSession = currentSession;
    }

    public void drawBoard() {

    }

    public void updateBoard() {

    }
}
