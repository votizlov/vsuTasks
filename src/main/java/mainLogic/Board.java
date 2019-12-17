package mainLogic;

import figures.Figure;
import figures.King;
import figures.Man;

import java.util.LinkedList;

public class Board {
    public Square getField() {
        return field;
    }

    private Square field;
    private Square lockedSquare = null;
    private Figure[] moveProcessors;

    Board(int x, int y) {
        moveProcessors = new Figure[]{new Man(Colors.WHITE), new Man(Colors.BLACK), new King(Colors.WHITE), new King(Colors.BLACK)};

        boolean placeFlag = false;
        int k = 1;
        for (int i = 0; i < y; i++) {
            Square prevSquare = null;
            for (int j = 0; j < x; j += k) {
                Square s = new Square(i, j);
                s.addConnection(prevSquare, ConnectionDirections.LEFT);
                if (i < 3 && placeFlag) {
                    s.setFigure(moveProcessors[0]);
                } else if (i > 4 && placeFlag) {
                    s.setFigure(moveProcessors[1]);
                } else {
                    s.setFigure(null);
                }
                prevSquare = s;
                placeFlag = !placeFlag;
            }
            y = -y;
            k = -k;
        }
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
        if (move.isWhomMove() == Players.WHITE && move.getS2().getConnection(ConnectionDirections.UP_RIGHT) == null && move.getS2().getConnection(ConnectionDirections.UP_LEFT) == null) {
            return true;
        } else if (move.isWhomMove() == Players.BLACK && move.getS2().getConnection(ConnectionDirections.DOWN_RIGHT) == null && move.getS2().getConnection(ConnectionDirections.DOWN_LEFT) == null) {
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
        for (Square s:square
             ) {
            s.setFigure(null);
        }
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

    private Square getSquareByCoord(int i, int j) {
        if (field.getX() == i && field.getY() == j)
            return field;
        else {
            LinkedList<Square> path = new LinkedList<>();
            path.add(field);
            for (Square s : field.getConnections()
            ) {
                return visit(i, j, s,path);
            }
            return null;
        }
    }

    private Square visit(int i, int j, Square s,LinkedList<Square> path) {
        if (s.getX() == i && s.getY() == j)
            return s;
        else
            for (Square s1 : s.getConnections()
            ) {
                path.add(s1);
                return visit(i, j, s1,path);
            }
        return null;
    }
}
