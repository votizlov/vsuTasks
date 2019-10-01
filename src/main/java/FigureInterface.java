import java.util.LinkedList;

public interface FigureInterface {//TODO make figure superclass
    public LinkedList<Move> getAvailableMoves(Figure[][] field);
}
