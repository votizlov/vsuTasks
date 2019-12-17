package mainLogic;

import javafx.print.PageLayout;

import java.util.LinkedList;

public class Move {
    private Players isWhomMove;
    private Square s1;
    private Square s2;
    private LinkedList<Square> killedFigureSquare;


    public Move(Square s1, Square s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public Move(Square s1, Square s2, LinkedList<Square> killedFigureSquare) {
        this.s1 = s1;
        this.s2 = s2;
        this.killedFigureSquare = killedFigureSquare;
    }

    public Players isWhomMove() {
        return isWhomMove;
    }

    public Move setWhomMove(Players whomMove) {
        isWhomMove = whomMove;
        return this;
    }

    public void addDead(Square s){
        killedFigureSquare.add(s);
    }

    public Square getS2() {
        return s2;
    }

    public Square getS1() {
        return s1;
    }

    public LinkedList<Square> getKilledFigureSquare() {
        return killedFigureSquare;
    }
}
