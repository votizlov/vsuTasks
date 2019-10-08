package mainLogic;

public class BoardState {
    boolean suspendPlayerChange;
    Winners whoWins;
    String errorMessage;
    BoardState(boolean suspendPlayerChange, Winners whoWins){
        this.suspendPlayerChange = suspendPlayerChange;
        this.whoWins = whoWins;
    }
    BoardState(String errorMessage){this.errorMessage = errorMessage;}
}