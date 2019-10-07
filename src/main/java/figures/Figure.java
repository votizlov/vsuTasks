package figures;

import mainLogic.Move;
import mainLogic.Square;

import java.util.LinkedList;

public interface Figure {
    public LinkedList<Move> getAvailableMoves(Square square);
    public boolean getColor();
    public char getSymbol();
}
