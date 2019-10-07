package interfaceControllers;

import figures.Figure;
import mainLogic.BoardState;
import mainLogic.Move;
import mainLogic.Square;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleInterface implements ControllerInterface {
    HashMap<String, Square> stringSquareHashMap;
    Scanner scanner;

    public ConsoleInterface(Square[] board) {
        for(int i= 0; i<Math.sqrt(board.length); i++){
            for(int j = 0; j<Math.)
        }
        this.scanner = new Scanner(System.in);
    }

    public void print(String args) {
        System.out.println(args);
    }

    @Override
    public void drawBoard(boolean side) {

    }

    @Override
    public void updateBoard() {

    }

    @Override
    public Move parseMove() {
        String[] move = scanner.nextLine().split(" ");
        return new Move(stringSquareHashMap.get(move[0]), stringSquareHashMap.get(move[1]));
    }
}
