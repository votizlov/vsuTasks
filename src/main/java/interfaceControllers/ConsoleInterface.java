package interfaceControllers;

import figures.Figure;
import mainLogic.BoardState;
import mainLogic.Move;
import mainLogic.Square;
import mainLogic.WrongMoveException;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleInterface implements ControllerInterface {
    private HashMap<String, Square> stringSquareHashMap;
    private Scanner scanner;
    private Square[][] board;

    public ConsoleInterface(Square[][] board) {
        stringSquareHashMap = new HashMap<String, Square>();
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                stringSquareHashMap.put(j + " " + i, board[i][j]);
            }
        }
        this.scanner = new Scanner(System.in);
    }

    public void print(String args) {
        System.out.println(args);
    }

    @Override
    public void drawBoard(boolean side) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j].getSymbol());
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    @Override
    public void updateBoard() {

    }

    @Override
    public Move parseMove() {
        String[] coordinates = scanner.nextLine().split(" ");
        return new Move(stringSquareHashMap.get(coordinates[0]), stringSquareHashMap.get(coordinates[1]));
    }
}
