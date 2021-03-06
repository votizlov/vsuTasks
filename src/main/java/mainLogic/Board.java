package mainLogic;

import figures.Figure;
import figures.King;
import figures.Man;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Board {
    public HashSet<Square> getField() {
        return field;
    }

    private HashSet<Square> field;
    private Square lockedSquare = null;
    private Figure[] moveProcessors;
    private int squareN;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public void setField(HashSet<Square> field) {
        this.field = field;
    }

    Board(int x, int y) {
        moveProcessors = new Figure[]{new Man(Colors.WHITE_TEAM), new Man(Colors.BLACK_TEAM), new King(Colors.WHITE_TEAM), new King(Colors.BLACK_TEAM)};
        squareN = x * y;
        this.x = x;
        this.y = y;
        field = new HashSet<>();

        boolean placeFlag = false;
        for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j ++) {
                    Square s = new Square(i, j);
                    if (i < 3 && placeFlag) {
                        s.setFigure(moveProcessors[0]);
                    } else if (i > 4 && placeFlag) {
                        s.setFigure(moveProcessors[1]);
                    } else {
                        s.setFigure(null);
                    }
                    field.add(s);
                    placeFlag = !placeFlag;
                }
            placeFlag = !placeFlag;
        }
        Iterator<Square> it = field.iterator();
        Square t = null;
        for (int i = 0; i < squareN-1; i++) {
            t = it.next();
            createLinks(t);/*
            if (i < 3 && placeFlag) {
                t.setFigure(moveProcessors[0]);
            } else if (i > 4 && placeFlag) {
                t.setFigure(moveProcessors[1]);
            }*/
            placeFlag = !placeFlag;
        }
        placeFlag = !placeFlag;
    }


    private void createLinks(Square square) {
        int i = square.getX();
        int j = square.getY();
        if (i - 1 > 0 && j - 1 > 0) {
            square.setUpperLeft(getSquareByCoord(i - 1,j - 1));
        }
        if (i + 1 < y && j - 1 > 0) {
            square.setUpperRight(getSquareByCoord(i + 1,j - 1));
        }
        if (i - 1 > 0 && j + 1 < x) {
            square.setLowerLeft(getSquareByCoord(i - 1,j + 1));
        }
        if (i + 1 < y && j + 1 < x) {
            square.setLowerRight(getSquareByCoord(i + 1,j + 1));
        }
    }

    public void makeHumanMove(Move move) throws WrongMoveException {
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
            /*if (move.getS2().getFigure().getAvailableMoves(move.getS2()).size() != 0) {
                return new BoardState(true, Players.NOONE);
            } else {
                return new BoardState(false, Players.NOONE);
            }*/
        }
        // return new BoardState(false, Players.NOONE);//if move with this figure still available lock figure and dont change
    }

    private boolean isBecameKing(Move move) {
        if (move.isWhomMove() == Colors.WHITE_TEAM && move.getS2().getConnection(ConnectionDirections.UP_RIGHT) == null && move.getS2().getConnection(ConnectionDirections.UP_LEFT) == null) {
            return true;
        } else if (move.isWhomMove() == Colors.BLACK_TEAM && move.getS2().getConnection(ConnectionDirections.DOWN_RIGHT) == null && move.getS2().getConnection(ConnectionDirections.DOWN_LEFT) == null) {
            return true;
        }
        return false;
    }

    public void makeAIMove(Move move) {
        if (move.getKilledFigureSquare() != null)
            removeChecker(move.getKilledFigureSquare());
    }

    private void move(Move move) {
        Figure temp = move.getS1().getFigure();
        move.getS1().setFigure(null);
        move.getS2().setFigure(temp);
    }

    private void removeChecker(LinkedList<Square> square) {
        for (Square s : square
        ) {
            s.setFigure(null);
        }
    }

    private boolean isKillAvailable() {
        Iterator<Square> it = field.iterator();
        Square t;
        while (it.hasNext()) {
            t = it.next();
            if (t.getFigure() != null) {
                for (Move b : t.getFigure().getAvailableMoves(t)) {
                    if (b.getKilledFigureSquare() != null) {
                        return true;
                    }
                }
            }
        }
        return false;
}

    private Square getSquareByCoord(int i, int j) {
        Iterator<Square> it = field.iterator();
        Square t;
        while (it.hasNext()) {
            t = it.next();
            if (t.getX() == i && t.getY() == j)
                return t;
        }
        return null;
    }

    private Square visit(int i, int j, Square s, LinkedList<Square> path) {
        if (s.getX() == i && s.getY() == j)
            return s;
        else
            for (Square s1 : s.getConnections()
            ) {
                path.add(s1);
                return visit(i, j, s1, path);
            }
        return null;
    }
}
