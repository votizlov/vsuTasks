package figures;

import mainLogic.Move;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;

public class King implements Figure {
    private boolean color;

    public King(boolean color) {
        this.color = color;
    }

    @Override
    public LinkedList<Move> getAvailableMoves(Square square) {
        //TODO check 4 moves
        return null;
    }

    @Override
    public boolean getTeam() {
        return color;
    }

    @Override
    public Color getDrawable() {
        return null;
    }

    @Override
    public char getSymbol() {
        if(color) {
            return '1';
        } else {
            return 'I';
        }
    }
}
