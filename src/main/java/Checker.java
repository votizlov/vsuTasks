import java.util.LinkedList;

public class Checker {
    private FigureType type;
    private Boolean team;//true white, false black

    Checker() {
    }

    Checker(FigureType type) {
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }

    public Boolean getTeam() {
        return team;
    }

    public boolean checkMove(Move move) {
        return getAvailableMoves().contains(move);
    }

    public LinkedList<Move> getAvailableMoves(){
        LinkedList<Move> moves = new LinkedList<>();
        if (type == FigureType.MAN) {

        } else {

        }
        return moves;
    }
}
