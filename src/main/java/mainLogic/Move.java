package mainLogic;

import javafx.print.PageLayout;

public class Move {
    private Players isWhomMove;
    private Square s1;
    private Square s2;
    private Square killedFigureSquare;


    public Move(Square s1, Square s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public Move(Square s1, Square s2, Square killedFigureSquare){
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

    public Square getS2() {
        return s2;
    }

    public Square getS1() {
        return s1;
    }

    public Square getKilledFigureSquare() {
        return killedFigureSquare;
    }
}
