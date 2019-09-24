import com.sun.scenario.effect.impl.state.AccessHelper;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private boolean whomMove;
    private CheckersDrawer checkersDrawer;
    private int winFlag;//0 nobody,1 white,2 blac

    GameSession(SessionType sessionType) {
        this.sessionType = SessionType.PVP;
        mainBoard = new Board(this);
        winFlag = 0;
        //checkersDrawer = CheckersDrawer.getInstance(this);
        //checkersDrawer.drawBoard();
        //create controller w/ link to board
        ConsoleInterface consoleInterface = new ConsoleInterface(mainBoard);

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
                boardState = mainBoard.makeHumanMove(consoleInterface.getInput());
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        } while (boardState==null||boardState.whoWins==Winners.NOONE);
        consoleInterface.print(boardState.whoWins.toString());
    }

    public int getWinFlag() {
        return winFlag;
    }

    public boolean isWhomMove() {
        return whomMove;
    }
}
