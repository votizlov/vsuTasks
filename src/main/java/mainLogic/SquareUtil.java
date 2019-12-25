package mainLogic;

import java.util.LinkedList;

public class SquareUtil {
    public static Square[][] toArray(Square square) {
        return new Square[][]{new Square[]{square}};
    }

    public static LinkedList<Square> toList(Square square){
        LinkedList<Square> squares = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares.add(square);
                if(i%2==0)
                square = square.getConnection(ConnectionDirections.RIGHT);
                else
                    square = square.getConnection(ConnectionDirections.LEFT);
            }
            square = square.getConnection(ConnectionDirections.DOWN);
        }
        return squares;
    }

    public static Square getSquare(int i, int j,Square field) {
        if (field.getX() == i && field.getY() == j)
            return field;
        else {
            LinkedList<Square> path = new LinkedList<>();
            path.add(field);
            for (Square s : field.getConnections()
            ) {
                return visit(i, j, s, path);
            }
            return null;
        }
    }

    private static Square visit(int i, int j, Square s, LinkedList<Square> path) {
        if (s.getX() == i && s.getY() == j)
            return s;
        else
            for (Square s1 : s.getConnections()
            ) {
                path.add(s1);
                return visit(i, j, s1, path);
            }
        return null;
    }

}