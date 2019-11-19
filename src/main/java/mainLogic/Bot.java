package mainLogic;

public class Bot {
    private Board currentBoard;
    private boolean currentSide;
    Bot() {
    }

    public boolean move(Board board, boolean whomMove) {
        currentBoard=board;
        currentSide = whomMove;
        if (whomMove) {//true white false blue
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    //if(board.findMoves(i,j).size()!=0);
                }
            }
        } else {

        }
        return true;
    }


}
