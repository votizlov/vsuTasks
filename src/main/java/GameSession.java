public class GameSession {
    private SessionType sessionType;
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

    public void makeMove(Move move) throws WrongMoveException {
        if (mainBoard.checkValidMove(whomMove)) {

        } else {
            throw new WrongMoveException("Wrong move");
        }
    }

    public void makeMove() {//aiMove

    }

    public int getWinFlag() {
        return winFlag;
    }
}
