public class AI {
    private int[][] currentBoard;
    private boolean currentSide;
    AI() {
    }

    public Move generateMove(int[][] board, boolean whomMove) {
        currentBoard=board;
        currentSide = whomMove;
        if (whomMove) {//true white false blue
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(board[i][j]==1){
                        //findManMove();
                    } else if(board[i][j]==2){
                        //findKingMove();
                    }
                }
            }
        } else {

        }
        return new Move(0, 0, 0, 0);
    }


}
