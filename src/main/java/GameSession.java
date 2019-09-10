public class GameSession {
    private int sessionType;//0 PvP,2 PvE,3 EvE,1 online PvP
    private Board mainBoard;
    private boolean whomMove;
    private int winFlag;//0 nobody,1 white,2 black

    GameSession(int sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board();
        winFlag = 0;
        if (sessionType > 1) {
            //init AI
            if (sessionType == 3) {
//launch autoCheckers
            }
        } else if (sessionType == 1) {
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


    public int[][] getMainBoardArr() {
        return mainBoard.getBoard();
    }

    public int getWinFlag() {
        return winFlag;
    }
}
