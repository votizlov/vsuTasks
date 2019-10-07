package mainLogic;

import figures.Figure;
import figures.Man;

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
                if (i < 4 || i > 5) {
                    field[i * 4 + j] = new Square(new Man(false));
                } else {
                    field[i * 4 + j] = new Square();
                }
            }
        }
    }

    public BoardState makeHumanMove(Move move) throws WrongMoveException {
        if (move.getS1().getFigure().getColor() != move.isWhomMove()) {
            throw new WrongMoveException("Wrong team");
        }
        if (move.getS1().getFigure().getAvailableMoves(move.getS1()).contains(move)) { //if figures in the way + valid move check
            throw new WrongMoveException("Wrong move");
        }
        if (isKillAvailable() && move.getKilledFigureSquare() == null) {
            throw new WrongMoveException("You must kill");
        }
        move(move);
        if (move.getKilledFigureSquare() != null) {
            removeChecker(move.getKilledFigureSquare());
        }
        BoardState boardState = null;
        if (move.getS2().getFigure().getAvailableMoves(move.getS2()).size() != 0) {
            boardState = new BoardState("gay");
        } else {
            boardState = new BoardState("gay");
        }
        //if move with this figure still available lock figure and dont change
        return boardState;
    }

    public BoardState makeAIMove(Move move) {
        BoardState boardState = new BoardState("gay");
        return boardState;
    }

    private void move(Move move) {
        Figure temp = move.getS1().getFigure();
        move.getS1().setFigure(null);
        move.getS2().setFigure(temp);
    }

    private void removeChecker(Square square) {
        square.setFigure(null);
    }

    private boolean isKillAvailable() {
        return false;
    }
}
