package figures;

import mainLogic.Colors;
import mainLogic.Move;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;

public class Man implements Figure {
    private Colors color;

    public Man(Colors color) {
        this.color = color;
    }

    @Override
    public LinkedList<Move> getAvailableMoves(Square square) {
        LinkedList<Move> linkedList = new LinkedList<>();
        if (square.getUpperLeft() != null) {
            if (square.getUpperLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperLeft()));
            } else if (square.getUpperLeft().getUpperLeft() != null && square.getUpperLeft().getUpperLeft().getFigure().getTeam() != this.color && square.getUpperLeft().getUpperLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperLeft().getUpperLeft(), square.getUpperLeft()));
            }
        }

        if (square.getUpperRight() != null) {
            if (square.getUpperRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperRight()));
            } else if (square.getUpperRight().getUpperRight().getFigure().getTeam() != this.color && square.getUpperRight().getUpperRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getUpperRight().getUpperRight(), square.getUpperRight()));
            }
        }

        if (square.getLowerLeft() != null) {
            if (square.getLowerLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerLeft()));
            } else if (square.getLowerLeft().getLowerLeft().getFigure().getTeam() != this.color && square.getLowerLeft().getLowerLeft().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerLeft().getLowerLeft(), square.getLowerLeft()));
            }
        }
        if (square.getLowerRight() != null) {
            if (square.getLowerRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerRight()));
            } else if (square.getLowerRight().getLowerRight().getFigure().getTeam() != this.color && square.getLowerRight().getLowerRight().getFigure() == null) {
                linkedList.add(new Move(square, square.getLowerRight().getLowerRight(), square.getLowerRight()));
            }
        }

        return linkedList;
    }

    @Override
    public Colors getTeam() {
        return color;
    }

    @Override
    public Color getDrawable() {
        if (color == Colors.WHITE_TEAM) {
            return Color.white;
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public char getSymbol() {
        if (color == Colors.WHITE_TEAM) {
            return '0';
        } else {
            return 'O';
        }
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return "Man";
    }
}
