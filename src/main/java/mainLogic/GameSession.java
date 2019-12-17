package mainLogic;

import interfaceControllers.CheckersInterface;
import interfaceControllers.ConsoleInterface;
import interfaceControllers.InputListener;
import interfaceControllers.MoveEmitter;

import java.util.LinkedList;

public class GameSession implements InputListener {
    private SessionType sessionType;
    private Board mainBoard;
    private LinkedList<Player> whomMove = new LinkedList<Player>();
    private boolean isInterfaceEnabled = true;
    private MoveEmitter controllerInterface;
    BoardState boardState = null;

    public GameSession(SessionType sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board(8, 8);
        switch (sessionType){
            case EVE:;
            break;
            case PVE:;
            break;
            case PVP:;
            break;
            case ONLINE_PVP:;
            break;
        }

        MoveEmitter checkersInterface = new CheckersInterface(mainBoard.getField());
        checkersInterface.drawBoard(whomMove.peek());
        do {
            try {
                boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove.peek()));
                if (!boardState.suspendPlayerChange)//change player if needed
                    whomMove.add(whomMove.poll());
                checkersInterface.drawBoard(whomMove.peek());
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        } while (boardState == null || boardState.whoWins == Player.NOONE);
    }
    @Override
    public void move(Move move){
        try {
            if(whomMove == )
            boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove.peek()));
            if (!boardState.suspendPlayerChange)//change player if needed
                whomMove.add(whomMove.poll());
            checkersInterface.drawBoard(whomMove.peek());
        } catch (WrongMoveException e) {
            e.printStackTrace();
        }
    }

    private void startNewGame() {

    }

    private void resumeSavedGame() {

    }
}
