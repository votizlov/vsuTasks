import com.sun.scenario.effect.impl.state.AccessHelper;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private boolean whomMove;
    private CheckersDrawer checkersDrawer;
    private int winFlag;//0 nobody,1 white,2 black

    GameSession(SessionType sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board();
        winFlag = 0;
        checkersDrawer = new CheckersDrawer(this);
        checkersDrawer.drawBoard();
        if (sessionType == SessionType.PVE || sessionType == SessionType.EVE) {
            //init AI
            if (sessionType == SessionType.EVE) {
                //launch autoCheckers
            }
        } else if (sessionType == SessionType.ONLINE_PVP) {
            //init NetworkService
        }
    }

    public void makeMove(Move move) throws WrongMoveException {
        if(mainBoard.attemptMove(move, whomMove)){
            checkersDrawer.updateBoard();
        }
    }

    public void makeMove() {//aiMove

    }

    public void pick(){

    }

    public int getWinFlag() {
        return winFlag;
    }
}
