package figures;

import mainLogic.Move;
import mainLogic.Players;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;

public interface Figure {
    public LinkedList<Move> getAvailableMoves(Square square);
    public Players getTeam();
    public Color getDrawable();
    public char getSymbol();
}
