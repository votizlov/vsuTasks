package mainLogic;

import interfaceControllers.CheckersInterface;
import interfaceControllers.ConsoleInterface;
import interfaceControllers.ControllerInterface;

import java.util.LinkedList;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private LinkedList<Players> whomMove = new LinkedList<Players>();
    private boolean isInterfaceEnabled = true;
    private ControllerInterface controllerInterface;

    public GameSession(SessionType sessionType) {
        this.sessionType = SessionType.PVP;
        for (Players p : Players.values()
        ) {
            if (p != Players.NOONE)
                whomMove.addFirst(p);
        }
        mainBoard = new Board(8, 8);
        ConsoleInterface consoleInterface = new ConsoleInterface(mainBoard.getField());
        CheckersInterface checkersInterface = new CheckersInterface(mainBoard.getField());
        checkersInterface.drawBoard(whomMove.peek());
        BoardState boardState = null;
        do {
            try {
                consoleInterface.drawBoard(whomMove.peek());
                boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove.peek()));
                if (!boardState.suspendPlayerChange)//change player if needed
                    whomMove.add(whomMove.poll());
                consoleInterface.drawBoard(whomMove.peek());
                checkersInterface.drawBoard(whomMove.peek());
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
