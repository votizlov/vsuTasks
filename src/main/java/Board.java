import java.util.LinkedList;

public class Board {
    public Figure[][] getField() {
        return field;
    }

    private Figure[][] field;
    private boolean isKillAvailable = false;
    private Figure lockedFigure = null;

    Board() {
        field = new Figure[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = new Figure<Man>();
            }
            //заполнение доски
        }
    }

    public BoardState makeHumanMove(Move move) throws WrongMoveException{
         if(field[move.getX1()][move.getY1()].getTeam()!=move.isWhomMove()){
             throw new WrongMoveException("Wrong team");
         }
         if(field[move.getX1()][move.getY1()].getAvailableMoves().contains(move)){ //if figures in the way + valid move check
             throw new WrongMoveException("Wrong move");
         }
         if(isKillAvailable&&move.getDeadX()<0){
             throw new WrongMoveException("You must kill");
         }
         move(move);
         if(move.getDeadX()>=0){
             removeChecker(move.getDeadX(),move.getDeadY());
         }
         //if move with this figure still available lock figure and dont change
         BoardState boardState = new BoardState("gay");
         return boardState;
    }

    public BoardState makeAIMove(Move move){
        BoardState boardState = new BoardState("gay");
        return boardState;
    }

    private void move(Move move){
        Figure temp = field[move.getX1()][move.getY1()];
        field[move.getX1()][move.getY1()] = null;
        field[move.getX2()][move.getY2()] = temp;
    }

    private void removeChecker(int x,int y){
        field[x][y]=null;
    }

}
