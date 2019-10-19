package mainLogic;

import interfaceControllers.ConsoleInterface;
import interfaceControllers.ControllerInterface;

import java.util.LinkedList;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private LinkedList<Players> whomMove = new LinkedList<Players>();//todo make linked list
    private boolean isInterfaceEnabled = true;
    private ControllerInterface controllerInterface;

    public GameSession(SessionType sessionType) {
        this.sessionType = SessionType.PVP;
        for (Players p:Players.values()
             ) {
            if(p!=Players.NOONE)
                whomMove.addFirst(p);
        }
        mainBoard = new Board(8, 8);
        ConsoleInterface consoleInterface = new ConsoleInterface(mainBoard.getField());
        BoardState boardState = null;
        consoleInterface.drawBoard(whomMove.peek());
        do {
            try {
                boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove.peek()));
                if (!boardState.suspendPlayerChange)//change player if needed
                    whomMove.add(whomMove.poll());
                consoleInterface.drawBoard(whomMove.peek());
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
