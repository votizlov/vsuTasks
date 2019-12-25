package mainLogic;

import interfaceControllers.InputListener;

public class Bot implements InputListener {
    private Board board;
    private Player side;

    public Bot(Board board, Player side) {
        this.board = board;
        this.side = side;
    }

    Bot() {
    }

    public Move move(Board board, Player whomMove) {
        //todo iterator
        return null;
    }


    @Override
    public void move(Move m) {

    }

    @Override
    public void save(String path) {

    }

    @Override
    public void load(String path) {

    }
}
