package mainLogic;

import figures.Figure;
import figures.King;
import figures.Man;

public class Board {
    public Square[][] getField() {
        return field;
    }

    private Square[][] field;
    private Square lockedSquare = null;
    private Figure[] moveProcessors;

    Board(int x,int y) {
        moveProcessors = new Figure[]{new Man(true), new Man(false), new King(true), new King(false)};
        field = new Square[x][y];
        boolean placeFlag = false;
        for (Square[] a : field
        ) {
            for (Square s : a
            ) {
                if(placeFlag)
                    s = new Square();
                placeFlag = !placeFlag;
            }
        }//todo make links or delete that shit
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (i < 4) {
                    field[i][j] = new Square(moveProcessors[0]);
                } else if (i > 5) {
                    field[i][j] = new Square(moveProcessors[1]);
                } else {
                    field[i][j] = new Square();
                }
            }
        }
    }

    public BoardState makeHumanMove(Move move) throws WrongMoveException {
        if (move.getS1() == null || move.getS2() == null) {
            throw new WrongMoveException("Wrong move");
        }
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
            if (move.getS2().getFigure().getAvailableMoves(move.getS2()).size() != 0) {
                return new BoardState(true, Winners.NOONE);
            } else {
                return new BoardState(false, Winners.NOONE);
            }
        }
        return new BoardState(false, Winners.NOONE);//if move with this figure still available lock figure and dont change
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
        for (Square[] square : field
        ) {
            for (Square a : square
            ) {
                if (a.getFigure() != null) {
                    for (Move b : a.getFigure().getAvailableMoves(a)) {
                        if (b.getKilledFigureSquare() != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
