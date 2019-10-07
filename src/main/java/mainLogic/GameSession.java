package mainLogic;

import interfaceControllers.CheckersDrawer;
import interfaceControllers.ConsoleInterface;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private boolean whomMove;
    private CheckersDrawer checkersDrawer;
    private int winFlag;//0 nobody,1 white,2 blac

    GameSession(SessionType sessionType) {
        this.sessionType = SessionType.PVP;
        mainBoard = new Board(8, 8);
        winFlag = 0;
        ConsoleInterface consoleInterface = new ConsoleInterface(mainBoard.getField());

        if (sessionType == SessionType.PVE || sessionType == SessionType.EVE) {
            //init AI
            if (sessionType == SessionType.EVE) {
                //launch autoCheckers
            }
        } else if (sessionType == SessionType.ONLINE_PVP) {
            //init NetworkService
        }
        BoardState boardState = null;
        do {
            try {
                boardState = mainBoard.makeHumanMove(consoleInterface.parseMove().setWhomMove(whomMove));
                if (!boardState.suspendPlayerChange)//change player if needed
                    whomMove = !whomMove;
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        } while (boardState == null || boardState.whoWins == Winners.NOONE);
        consoleInterface.print(boardState.whoWins.toString());
    }
}
