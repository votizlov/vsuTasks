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
    private Bot bot;

    public GameSession(SessionType sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board(8, 8);
        switch (sessionType){
            case EVE:Bot bot = new Bot();

            break;
            case PVE:;
            break;
            case PVP:;
            break;
            case ONLINE_PVP:;
            break;
        }

        MoveEmitter checkersInterface = new CheckersInterface(mainBoard.getField());
        checkersInterface.drawBoard();
    }
    @Override
    public void move(Move move){
        if (whomMove.peek().getType()==playerType.BOT){
            mainBoard.makeAIMove(bot.move(mainBoard,whomMove.peek()));
            whomMove.addLast(whomMove.poll());
        } else {
            try {
                mainBoard.makeHumanMove(move);
                controllerInterface.drawBoard();
                whomMove.addLast(whomMove.poll());
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        }
    }

    private void startNewGame() {

    }

    private void resumeSavedGame() {

    }
}
