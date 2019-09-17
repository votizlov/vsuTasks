import java.util.LinkedList;

public class Board {
    private Checker[][] field;

    Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

            }
            //заполнение доски
        }
    }


    public boolean attemptMove(Move move, boolean whomMove) throws WrongMoveException {
        if (move.getChecker1().getTeam() != whomMove) {
            throw new WrongMoveException("Wrong team");
        }
        if (!move.getChecker1().checkMove(move)) {
            throw new WrongMoveException("Wrong move");
        }
    }
}
