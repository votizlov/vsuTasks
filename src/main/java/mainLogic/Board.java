package mainLogic;

import figures.Figure;
import figures.King;
import figures.Man;

import java.util.LinkedList;

public class Board {
    public Square[][] getField() {
        return field;
    }

    private Square[][] field;
    private Square lockedSquare = null;
    private Figure[] moveProcessors;

    Board(int x, int y) {
        moveProcessors = new Figure[]{new Man(Players.WHITE), new Man(Players.BLACK), new King(Players.WHITE), new King(Players.BLACK)};
        field = new Square[x][y];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new Square();
            }
        }
        boolean placeFlag = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                createLinks(field[i][j], i, j);
                if (i < 3 && placeFlag) {
                    field[i][j] = new Square(moveProcessors[0]);
                } else if (i > 4 && placeFlag) {
                    field[i][j] = new Square(moveProcessors[1]);
                } else {
                    field[i][j] = new Square();
                }
                placeFlag = !placeFlag;
            }
            placeFlag = !placeFlag;
        }
    }

    private void createLinks(Square square, int i, int j) {
        if (i - 1 > 0 && j - 1 > 0) {
            square.setUpperLeft(field[i - 1][j - 1]);
        }
        if (i + 1 < field.length && j - 1 > 0) {
            square.setUpperRight(field[i + 1][j - 1]);
        }
        if (i - 1 > 0 && j + 1 < field[0].length) {
            square.setLowerLeft(field[i - 1][j + 1]);
        }
        if (i + 1 < field.length && j + 1 < field[0].length) {
            square.setLowerRight(field[i + 1][j + 1]);
        }
    }

    public BoardState makeHumanMove(Move move) throws WrongMoveException {
        if (move.getS1() == null || move.getS2() == null) {
            throw new WrongMoveException("Wrong move");
        }
        if (move.getS1().getFigure().getTeam() == move.isWhomMove()) {
            throw new WrongMoveException("Wrong team");
        }
        LinkedList<Move> availableMoves = move.getS1().getFigure().getAvailableMoves(move.getS1());
        System.out.println(availableMoves.size());
        if (availableMoves.contains(move)) { //if figures in the way + valid move check
            throw new WrongMoveException("Wrong move");
        }
        if (isKillAvailable() && move.getKilledFigureSquare() == null) {
            throw new WrongMoveException("You must kill");
        }
        move(move);
        if (isBecameKing(move)) {
            //move.getS2().setFigure(new King(move.getS2().getFigure().getTeam()));
        }
        for (Move m : availableMoves
        ) {
            if (m == move) {
                move = m;
                break;
            }
        }
        if (move.getKilledFigureSquare() != null) {
            removeChecker(move.getKilledFigureSquare());
            if (move.getS2().getFigure().getAvailableMoves(move.getS2()).size() != 0) {
                return new BoardState(true, Players.NOONE);
            } else {
                return new BoardState(false, Players.NOONE);
            }
        }
        return new BoardState(false, Players.NOONE);//if move with this figure still available lock figure and dont change
    }

    private boolean isBecameKing(Move move) {
        if (move.isWhomMove() == Players.WHITE && move.getS2().getUpperRight() == null && move.getS2().getUpperLeft() == null) {
            return true;
        } else if (move.isWhomMove() == Players.BLACK && move.getS2().getLowerRight() == null && move.getS2().getLowerLeft() == null) {
            return true;
        }
        return false;
    }

    public BoardState makeAIMove(Move move) {
        BoardState boardState = new BoardState("not implemented");
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
