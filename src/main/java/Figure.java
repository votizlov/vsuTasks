import java.util.LinkedList;

public class Figure<T extends FigureInterface> {
    private Boolean team;//true white, false black
    private T figure;

    Figure() {
    }

    Figure(T type) {
        this.figure = type;
    }

    public T getType() {
        return figure;
    }

    public Boolean getTeam() {
        return team;
    }

    public LinkedList<Move> getAvailableMoves(Figure[][] board){
        LinkedList<Move> moves = new LinkedList<>();
        return figure.getAvailableMoves(board);
    }
}
