public class GameSession {
    private int sessionType;//0 PvP,2 PvE,3 EvE,1 online PvP
    private Board mainBoard;
    private boolean whomMove;
    GameSession(int sessionType){
        this.sessionType=sessionType;
        mainBoard = new Board();
        if(sessionType>1){
            //init AI
            if(sessionType==3){
//launch autoCheckers
            }
        } else if(sessionType==1){
            //init NetworkService
        }
    }
    public int makePlayerMove(Move move){//returns 0 if ok,1 wrong team, 2 invalid move
return 0;
    }
    private void makeAIMove(){

    }


    public int[][] getMainBoardArr() {
        return mainBoard.getBoard();
    }
}
