import com.sun.scenario.effect.impl.state.AccessHelper;

public class GameSession {
    private SessionType sessionType;
    private Board mainBoard;
    private boolean whomMove;
    private CheckersDrawer checkersDrawer;
    private int winFlag;//0 nobody,1 white,2 blac

    GameSession(SessionType sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board(this);
        winFlag = 0;
        checkersDrawer = new CheckersDrawer(this);
        if (sessionType == SessionType.PVE || sessionType == SessionType.EVE) {
            //init AI
            if (sessionType == SessionType.EVE) {
                //launch autoCheckers
            }
        } else if (sessionType == SessionType.ONLINE_PVP) {
            //init NetworkService
        }
    }

    public int getWinFlag() {
        return winFlag;
    }

    public boolean isWhomMove() {
        return whomMove;
    }
}
