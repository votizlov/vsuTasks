package mainLogic;

public class BoardState {
    boolean whomMove;
    Winners whoWins;
    String errorMessage;
    BoardState(boolean whomMove, Winners whoWins){
        this.whomMove = whomMove;
        this.whoWins = whoWins;
    }
    BoardState(String errorMessage){this.errorMessage = errorMessage;}
}