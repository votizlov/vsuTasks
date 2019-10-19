package interfaceControllers;

import mainLogic.Move;
import mainLogic.Players;

public interface ControllerInterface {
    void drawBoard(Players side);
    void updateBoard(Players side);
    Move parseMove() throws InterruptedException;
}
