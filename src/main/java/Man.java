import java.util.LinkedList;

public class Man extends Figure {
    private boolean color;

    Man() {
    }

    Man(int x, int y) {
    }

    @Override
    public LinkedList<Move> getAvailableMoves(Square square) {
        LinkedList<Move> linkedList = new LinkedList<>();
        if (square.getUpperLeft()!=null){
            //linkedList.add(new Move(x,y,x-1,y-1));
        }
        if (square.getUpperRight()!=null){
            //linkedList.add(new Move(x,y,x-1,y+1));
        }
        if (square.getLowerLeft()!=null){
            //linkedList.add(new Move(x,y,x+1,y-1));
        }
        if (square.getLowerRight()!=null){
            //linkedList.add(new Move(x,y,x+1,y+1));
        }

        return linkedList;
    }

    @Override
    public boolean getColor() {
        return color;
    }
}
