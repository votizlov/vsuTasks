package interfaceControllers;

import mainLogic.Move;

public interface ControllerInterface {
    void drawBoard(boolean side);
    void updateBoard(boolean side);
    Move parseMove() throws InterruptedException;
}
