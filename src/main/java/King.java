import java.util.LinkedList;

public class King implements Figure {
    private int x;
    private int y;
    private boolean color;

    King() {
    }

    King(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LinkedList<Move> getAvailableMoves(Figure[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

            }
        }
        return null;
    }

    @Override
    public boolean getColor() {
        return color;
    }
}
