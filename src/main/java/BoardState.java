public class BoardState {
    boolean whomMove;
    boolean whoWins;
    String errorMessage;
    BoardState(boolean whomMove, boolean whoWins){
        this.whomMove = whomMove;
        this.whoWins = whoWins;
    }
    BoardState(String errorMessage){this.errorMessage = errorMessage;}
}
