package figures;

import mainLogic.Colors;
import mainLogic.Move;
import mainLogic.Players;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;

public class King implements Figure {
    private Colors color;

    public King(Colors color) {
        this.color = color;
    }

    @Override
    public LinkedList<Move> getAvailableMoves(Square square) {
        LinkedList<Move> linkedList = new LinkedList<>();
        Square t = square.getUpperLeft();
        while (t != null) {
            if (square.getUpperLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperLeft()));
            } else if (square.getUpperLeft().getUpperLeft() != null && square.getUpperLeft().getUpperLeft().getFigure().getTeam() != this.color && square.getUpperLeft().getUpperLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperLeft().getUpperLeft(), square.getUpperLeft()));
                break;
            }
            t = t.getUpperLeft();
        }
        t = square.getUpperRight();
        while (t != null) {
            if (square.getUpperRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperRight()));
            } else if (square.getUpperRight().getUpperRight().getFigure().getTeam() != this.color && square.getUpperRight().getUpperRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperRight().getUpperRight(), square.getUpperRight()));
                break;
            }
            t = t.getLowerRight();
        }
        t = square.getLowerLeft();
        while (t != null) {
            if (square.getLowerLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerLeft()));
            } else if (square.getLowerLeft().getLowerLeft().getFigure().getTeam() != this.color && square.getLowerLeft().getLowerLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerLeft().getLowerLeft(), square.getLowerLeft()));
                break;
            }
            t = t.getLowerLeft();
        }
        t = square.getLowerRight();
        while (t != null) {
            if (square.getLowerRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerRight()));
            } else if (square.getLowerRight().getLowerRight().getFigure().getTeam() != this.color && square.getLowerRight().getLowerRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerRight().getLowerRight(), square.getLowerRight()));
                break;
            }
            t = t.getLowerRight();
        }
        return linkedList;
    }

    @Override
    public Colors getTeam() {
        return color;
    }

    @Override
    public Color getDrawable() {
        return null;
    }

    @Override
    public char getSymbol() {
        if (color == Colors.WHITE) {
            return '1';
        } else {
            return 'I';
        }
    }
}
