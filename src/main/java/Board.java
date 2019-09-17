import java.util.LinkedList;

public class Board {
    private Checker[][] field;

    Board() {
        field = new Checker[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = new Checker();
            }
            //заполнение доски
        }
    }


    public void move(Move move) {

    }
}
