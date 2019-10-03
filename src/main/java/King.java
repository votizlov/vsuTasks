import java.util.LinkedList;

public class King extends Figure {
    private boolean color;

    King() {
    }

    King(int x, int y) {
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
