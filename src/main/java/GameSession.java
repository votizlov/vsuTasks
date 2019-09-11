public class GameSession {
    private SessionType sessionType;//0 PvP,2 PvE,3 EvE,1 online PvP
    private Board mainBoard;
    private boolean whomMove;
    private int winFlag;//0 nobody,1 white,2 black

    GameSession(SessionType sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board();
        winFlag = 0;
        if (sessionType == SessionType.PVE || sessionType == SessionType.EVE) {
            //init AI
            if (sessionType == SessionType.EVE) {
                //launch autoCheckers
            }
        } else if (sessionType == SessionType.ONLINE_PVP) {
            //init NetworkService
        }
    }

    public int makeMove(Move move) {//human move, returns 0 if ok,1 wrong team, 2 invalid move
        if (move.checkValidTeam(whomMove)) {
            return 1;
        } else if (move.checkValidMove(mainBoard.getBoard())) {
            return 2;
        } else {
            return 0;
        }
    }

    public void makeMove() {//aiMove

    }

    public int getWinFlag() {
        return winFlag;
    }
}
