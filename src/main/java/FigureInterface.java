import java.util.LinkedList;

public interface FigureInterface {
    public LinkedList<Move> getAvailableMoves(Figure[][] field);
}
