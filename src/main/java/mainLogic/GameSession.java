package mainLogic;

import interfaceControllers.CheckersInterface;
import interfaceControllers.ConsoleInterface;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private boolean whomMove;
    private int winFlag;//0 nobody,1 white,2 blac

    public GameSession(SessionType sessionType) {
        this.sessionType = SessionType.PVP;
        mainBoard = new Board(8, 8);
        winFlag = 0;
        ConsoleInterface consoleInterface = new ConsoleInterface(mainBoard.getField());
        CheckersInterface checkersInterface = new CheckersInterface(mainBoard.getField());
        checkersInterface.drawBoard(true);
        if (sessionType == SessionType.PVE || sessionType == SessionType.EVE) {
            //init AI
            if (sessionType == SessionType.EVE) {
                //launch autoCheckers
            }
        } else if (sessionType == SessionType.ONLINE_PVP) {
            //init NetworkService
        }
        BoardState boardState = null;
        consoleInterface.drawBoard(true);
        do {
            try {
                boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove));
                if (!boardState.suspendPlayerChange)//change player if needed
                    whomMove = !whomMove;
                consoleInterface.drawBoard(whomMove);
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        } while (boardState == null || boardState.whoWins == Winners.NOONE);
        consoleInterface.print(boardState.whoWins.toString());
    }
}
