import java.util.LinkedList;

public class Board {
    private Figure[][] field;
    private GameSession gameSession;
    private boolean isKillAvailable = false;
    private Figure lockedFigure = null;

    Board(GameSession gameSession) {
        this.gameSession = gameSession;
        field = new Figure[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = new Figure();
            }
            //заполнение доски
        }
    }

    public boolean makeHumanMove(Move move) throws WrongMoveException{
         if(field[move.getX1()][move.getY1()].getTeam()!=gameSession.isWhomMove()){
             throw new WrongMoveException("Wrong team");
         }
         if(!findMoves(move.getX1(),move.getY1()).contains(move)){
             throw new WrongMoveException("Wrong move");
         }
         if(isKillAvailable&&move.getDeadX()<0){
             throw new WrongMoveException("You must kill");
         }
         move(move);
         if(move.getDeadX()>=0){
             removeChecker(move.getDeadX(),move.getDeadY());
         }
         return true;
    }

    private void move(Move move){
        Figure temp = field[move.getX1()][move.getY1()];
        field[move.getX1()][move.getY1()] = null;
        field[move.getX2()][move.getY2()] = temp;
    }

    private void removeChecker(int x,int y){
        field[x][y]=null;
    }

    public LinkedList<Move> findMoves(int x,int y){
        LinkedList<Move> moves = new LinkedList<>();
        if(field[x][y].getType()==FigureType.MAN){

        } else {

        }
        return moves;
    }
}
