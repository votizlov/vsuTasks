package mainLogic;

public class BoardState {
    boolean suspendPlayerChange;
    Players whoWins;
    String errorMessage;

    BoardState(boolean suspendPlayerChange, Players whoWins) {
        this.suspendPlayerChange = suspendPlayerChange;
        this.whoWins = whoWins;
    }

    BoardState(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}