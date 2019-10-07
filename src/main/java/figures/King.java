package figures;

import mainLogic.Move;
import mainLogic.Square;

import java.util.LinkedList;

public class King extends Figure {
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
    public boolean getColor() {
        return color;
    }
}
