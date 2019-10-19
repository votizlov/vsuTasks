package mainLogic;

import interfaceControllers.CheckersInterface;
import interfaceControllers.ConsoleInterface;
import interfaceControllers.ControllerInterface;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private boolean whomMove;//todo make linked list
    private boolean isInterfaceEnabled = true;

    public GameSession(SessionType sessionType) {
        this.sessionType = SessionType.PVP;
        mainBoard = new Board(8, 8);
        ControllerInterface controllerInterface = new CheckersInterface(mainBoard.getField());
        ConsoleInterface consoleInterface = new ConsoleInterface(mainBoard.getField());
        CheckersInterface checkersInterface = new CheckersInterface(mainBoard.getField());
        checkersInterface.drawBoard(true);
        BoardState boardState = null;
        consoleInterface.drawBoard(true);
        do {
            try {
                boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove));
                //boardState = mainBoard.makeHumanMove(checkersInterface.parseMove().setWhomMove(whomMove));
                if (!boardState.suspendPlayerChange)//change player if needed
                    whomMove = !whomMove;
                consoleInterface.drawBoard(whomMove);
                checkersInterface.drawBoard(whomMove);
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        } while (boardState == null || boardState.whoWins == Players.NOONE);
        consoleInterface.print(boardState.whoWins.toString());
    }

    private void startNewGame() {

    }

    private void resumeSavedGame() {

    }
}
