import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedList;

public class Board {
    public Square[] getField() {
        return field;
    }

    private Square[] field;
    private boolean isKillAvailable = false;
    private Figure lockedFigure = null;
    private Figure[] moveProcessors;

    Board() {
        field = new Square[32];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if(i<4||i>5) {
                    field[i * 4 + j] = new Square(new Man());
                } else {
                    field[i * 4 + j] = new Square();
                }
            }
        }
    }

    public BoardState makeHumanMove(Move move) throws WrongMoveException {
        if (field[move.getX1()].getFigure().getColor() != move.isWhomMove()) {
            throw new WrongMoveException("Wrong team");
        }
        if (field[move.getX1()].getFigure().getAvailableMoves(field[move.getX1()]).contains(move)) { //if figures in the way + valid move check
            throw new WrongMoveException("Wrong move");
        }
        if (isKillAvailable && move.getDeadX() < 0) {
            throw new WrongMoveException("You must kill");
        }
        move(move);
        if (move.getDeadX() >= 0) {
            removeChecker(move.getDeadX(), move.getDeadY());
        }
        //if move with this figure still available lock figure and dont change
        BoardState boardState = new BoardState("gay");
        return boardState;
    }

    public BoardState makeAIMove(Move move) {
        BoardState boardState = new BoardState("gay");
        return boardState;
    }

    private void move(Move move) {
        Figure temp = field[move.getX1()].getFigure();
        field[move.getX1()].setFigure(null);
        field[move.getX2()].setFigure(temp);
    }

    private void removeChecker(int x, int y) {
        field[x].setFigure(null);
    }


}
