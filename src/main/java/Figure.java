import java.util.LinkedList;

public interface Figure {//TODO make figure superclass
    LinkedList<Move> getAvailableMoves(Figure[][] field);
    boolean getColor();
}
