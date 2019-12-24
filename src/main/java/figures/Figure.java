package figures;

import mainLogic.Colors;
import mainLogic.Move;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;

public interface Figure {
    public LinkedList<Move> getAvailableMoves(Square square);
    public Colors getTeam();
    public Color getDrawable();
    public char getSymbol();
}
