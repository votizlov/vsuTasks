import java.util.Scanner;

public class ConsoleInterface {
    Board board;
    Scanner scanner;

    ConsoleInterface(Board board) {
        this.board = board;
        this.scanner = new Scanner(System.in);
    }

    public Move getInput() {//тут бля без цикла
        BoardState boardState = null;
        return new Move(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
    }

    public void print(String args){
        System.out.println(args);
    }

    public void drawBoard(boolean side) {

    }
}
