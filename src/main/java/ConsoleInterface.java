import java.util.Scanner;

public class ConsoleInterface {
    Figure[][] board;
    Scanner scanner;

    ConsoleInterface(Figure[][] board) {
        this.board = board;
        this.scanner = new Scanner(System.in);
    }

    public Move getInput() {
        BoardState boardState = null;
        return new Move(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
    }

    public void print(String args){
        System.out.println(args);
    }

    public void drawBoard(boolean side) {
        for (int i=0;i<board.length+2;i++){
            for(int j=0;j<board[0].length+2;j++){
                //drawing
            }
        }
    }
}
